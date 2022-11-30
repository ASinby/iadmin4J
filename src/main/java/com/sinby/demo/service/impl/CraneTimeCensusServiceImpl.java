package com.sinby.demo.service.impl;

import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sinby.demo.dao.CraneStatusDao;
import com.sinby.demo.dao.CraneTimeCensusDao;
import com.sinby.demo.pojo.CraneTimeCensus;
import com.sinby.demo.service.CraneTimeCensusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.*;
import java.util.function.Function;

/**
 * @author：sinby
 * @Date: 2022/09/20 10:42
 * @Description: XXXX
 */
@Service
public class CraneTimeCensusServiceImpl implements CraneTimeCensusService {

    @Autowired
    CraneTimeCensusDao craneTimeCensusDao;

    @Autowired
    CraneStatusDao craneStatusDao;

    @Override
    public boolean saveBatch(Collection<CraneTimeCensus> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean saveOrUpdateBatch(Collection<CraneTimeCensus> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean updateBatchById(Collection<CraneTimeCensus> entityList, int batchSize) {
        return false;
    }

    @Transactional
    @Override
    public boolean saveOrUpdate(CraneTimeCensus entity) {

        Map<String,Object> param = new HashMap<>();

        try {

            //1、计算作业时长
            long workTm = DateUtil.between(entity.getUpTime(),entity.getDownTime(), DateUnit.SECOND);
            if(entity.getWorkTm() == null){ //若作业时长为空，则使用程序计算值
                entity.setWorkTm(BigDecimal.valueOf(workTm));
            }

            //2、计算避让时长
            String startDestLoc = entity.getStartLoc()+"->"+entity.getDestLoc();
            param.put("startDestLoc",startDestLoc);
            List<Map<String,Object>> minTm = craneStatusDao.checkExistOfMinTm(param);
            if(!minTm.isEmpty() && minTm.size()!=0){
                if(entity.getAvoidTm()==null){
                    entity.setAvoidTm(entity.getWorkTm().subtract(BigDecimal.valueOf(Long.parseLong(minTm.get(0).get("minTm").toString()))));
                }
            }

            //3、检查CRANE_TIME_CENSUS中是否存在此记录，若不存在 插入
            CraneTimeCensus result = craneTimeCensusDao.selectById(entity.getCmdno());
            if(result==null){
                craneTimeCensusDao.insert(entity);
            }

            QueryWrapper<CraneTimeCensus> wrapper = new QueryWrapper<>();   //Mybatis-Plus 条件构造器
            wrapper.eq("CRNO",entity.getCrno()).le("CMDNO",entity.getCmdno()).orderByDesc("UP_TIME"); //根据行车查询并按UP_TIME倒序

            List<CraneTimeCensus> tempRows = craneTimeCensusDao.selectList(wrapper);

            //4、获取到达时间
            if(!tempRows.isEmpty() && tempRows.size()>=2){

                CraneTimeCensus row0 = tempRows.get(0);
                CraneTimeCensus row1 = tempRows.get(1);

                param.clear();
                param.put("crno",row0.getCrno());
                param.put("startTime",DateUtil.format(row1.getDownTime(),"yyyy-MM-dd HH:mm:ss"));
                param.put("endTime",DateUtil.format(row0.getUpTime(),"yyyy-MM-dd HH:mm:ss"));
                param.put("arrive",row0.getStartLoc());

                List<Map<String, Object>> arriveTimes =  craneTimeCensusDao.getArriveLeaveTime(param);

                Date arriveTime = null;    //到达时间
                if(!arriveTimes.isEmpty() && arriveTimes.size()>=2){
                    for(int i=0; i<arriveTimes.size()-1; ++i){
                        Date tm1 = DateUtil.parse(String.valueOf(arriveTimes.get(i).get("tm")),"yyyy-MM-dd HH:mm:ss");
                        Date tm2 = DateUtil.parse(String.valueOf(arriveTimes.get(i+1).get("tm")),"yyyy-MM-dd HH:mm:ss");

                        long diff = DateUtil.between(tm1,tm2,DateUnit.SECOND);
                        if(diff<=2){
                            arriveTime = tm1;
                            break;
                        }
                    }
                }

                //4.1、计算准备时长
                if(arriveTime!=null){
                    long prepareTm = DateUtil.between(arriveTime, entity.getUpTime(),DateUnit.SECOND);

                    entity.setArriveTime(new Timestamp(arriveTime.getTime()));
                    entity.setPrepareTm(BigDecimal.valueOf(prepareTm));
                }
            }

            //5、获取离开时间
            if(!tempRows.isEmpty() && tempRows.size()>0){
                CraneTimeCensus row3 = tempRows.get(0);

                param.clear();
                param.put("crno",row3.getCrno());
                param.put("startTime",DateUtil.format(row3.getUpTime(),"yyyy-MM-dd HH:mm:ss"));
                param.put("endTime",DateUtil.format(row3.getDownTime(),"yyyy-MM-dd HH:mm:ss"));
                param.put("leave",row3.getStartLoc());

                List<Map<String, Object>> leaveTimes =  craneTimeCensusDao.getArriveLeaveTime(param);

                Date leaveTime = null; //离开时间
                if(!leaveTimes.isEmpty() && leaveTimes.size()>0){
                    leaveTime = DateUtil.parse(String.valueOf(leaveTimes.get(leaveTimes.size()-1).get("tm")),"yyyy-MM-dd HH:mm:ss");
                }

                //5.1、计算吊起时长
                if(leaveTime!=null){
                    long upTm = DateUtil.between(entity.getUpTime(), leaveTime,DateUnit.SECOND);

                    entity.setLeaveTime(new Timestamp(leaveTime.getTime()));
                    entity.setUpTm(BigDecimal.valueOf(upTm));
                }
            }

            craneTimeCensusDao.updateById(entity);

            return true;
        } catch (Exception e) {
            e.printStackTrace();

            return false;
        }

    }

    @Override
    public CraneTimeCensus getOne(Wrapper<CraneTimeCensus> queryWrapper, boolean throwEx) {
        return null;
    }

    @Override
    public Map<String, Object> getMap(Wrapper<CraneTimeCensus> queryWrapper) {
        return null;
    }

    @Override
    public <V> V getObj(Wrapper<CraneTimeCensus> queryWrapper, Function<? super Object, V> mapper) {
        return null;
    }

    @Override
    public BaseMapper<CraneTimeCensus> getBaseMapper() {
        return null;
    }

    @Override
    public Class<CraneTimeCensus> getEntityClass() {
        return null;
    }

    @Override
    public List<Map<String, Object>> getArriveLeaveTime(Map<String, Object> param) {
        return craneTimeCensusDao.getArriveLeaveTime(param);
    }
}
