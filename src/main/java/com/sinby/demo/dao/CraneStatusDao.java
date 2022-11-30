package com.sinby.demo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sinby.demo.pojo.CraneStatus;
import com.sinby.demo.pojo.CraneTimeCensus;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author ：sinby
 * @Date :2022/03/24 10:15
 * @Version 1.0
 */
@Mapper
@Repository
public interface CraneStatusDao extends BaseMapper<CraneStatus> {

    //获取行车实时数据
    public List<CraneStatus> getCraneNowData(Map<String,Object> param);

    /**
     * 计算作业时长 并更新CRANE_CMD
     */
    public void calculateWorkTm();

    /**
     * 从CRANE_CMD表中取最小作业时长  不使用@MapKey时，出现@MapKey is required问题
     * @return
     */
    @MapKey("startDestLoc")
    public Map<String,Map<String,Object>> getMinTmForInsert();

    /**
     * 检验CRANE_WORK_MIN_TM是否已存在最小时长
     * @param param START_DEST_LOC
     * @return int
     */
    public List<Map<String,Object>> checkExistOfMinTm(Map<String,Object> param);

    /**
     * 向CRANE_WORK_MIN_TM表，插入最小作业时长
     * @param param
     */
    public void insertMinTm(Map<String,Object> param);

    /**
     * 修改CRANE_WORK_MIN_TM表中最小作业时长
     * @param param
     */
    public void updateMinTm(Map<String,Object> param);

    /**
     * 从CRANEM_CMD中获取命令号、吊起放下时间 等信息
     * @return
     */
    public List<CraneTimeCensus> getUpDownTimeForInsert();
}
