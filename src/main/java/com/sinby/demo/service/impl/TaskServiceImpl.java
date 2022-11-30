package com.sinby.demo.service.impl;

import com.sinby.demo.pojo.CraneTimeCensus;
import com.sinby.demo.pojo.ResultData;
import com.sinby.demo.service.CraneStatusService;
import com.sinby.demo.service.CraneTimeCensusService;
import com.sinby.demo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ：sinby
 * @Date :2022/04/26 14:34
 * @Version 1.0
 */
@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    CraneStatusService craneStatusService = null;

    @Autowired
    CraneTimeCensusService craneTimeCensusService = null;

    @Override
    // 每天凌晨1点开始执行任务
//    @Scheduled(cron = "0 0 1 * * ?")
    //两分钟执行一次（用于测试）
//    @Scheduled(fixedRate = 1000*60*2)
    public void purchaseTask() {
        System.out.println("定时任务开始……");

        List<CraneTimeCensus> rows = null;

        try {
            //1、计算工作时长时间
            craneStatusService.calculateWorkTm();

            //2、计算最小作业时长
            Map<String,Object> param = new HashMap<>();
            Map<String, Map<String,Object>> minTms = craneStatusService.getMinTmForInsert(); //获取所有最小时长

            for (String startDestLoc:minTms.keySet()) {
                param.put("startDestLoc",startDestLoc);

                List<Map<String,Object>> listMinTm = craneStatusService.checkExistOfMinTm(param);   //校验

                if(listMinTm.isEmpty() || listMinTm.size()==0){ //无 插入
                    craneStatusService.insertMinTm(minTms.get(startDestLoc));
                }else{

                    Integer minTm1 = Integer.parseInt(minTms.get(startDestLoc).get("minTm").toString());
                    Integer minTm2 = Integer.parseInt(listMinTm.get(0).get("minTm").toString());
                    if(minTm1<minTm2){
                        craneStatusService.updateMinTm(minTms.get(startDestLoc));
                    }
                }
            }

            //3、准备时长、吊起时长
            rows = craneStatusService.getUpDownTimeForInsert();

            for(CraneTimeCensus row:rows){
                craneTimeCensusService.saveOrUpdate(row);
            }

        } catch (Exception e) {

        }

        System.out.println("定时任务结束……");
    }
}
