package com.sinby.demo.controller;

import com.sinby.demo.pojo.CraneStatus;
import com.sinby.demo.pojo.CraneTimeCensus;
import com.sinby.demo.pojo.ResultData;
import com.sinby.demo.service.CraneStatusService;
import com.sinby.demo.service.CraneTimeCensusService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ：sinby
 * @Date :2022/03/24 14:09
 * @Version 1.0
 */
@Api(description = "行车数据接口")
@RestController
public class CraneStatusController {

    @Autowired
    CraneStatusService craneStatusService = null;

    @Autowired
    CraneTimeCensusService craneTimeCensusService = null;

    @GetMapping("/index")
    public ModelAndView testPage(){

        Map<String,String> param = new HashMap<>();

        ModelAndView mv = new ModelAndView("index");

        return mv;
    }

    @GetMapping("/getCraneNowData")
    public ResultData<List<CraneStatus>> getCraneNowData(){

        List<CraneStatus> list = craneStatusService.getCraneNowData(null);

        ResultData<List<CraneStatus>> resultData = new ResultData<>(true,"操作成功",200,list);

        return resultData;
    }

    @GetMapping("/calculateWorkTm")
    public ResultData<String> calculateWorkTm(){

        ResultData<String> resultData = null;

        try {
            craneStatusService.calculateWorkTm();

            resultData = new ResultData<>(true,"操作成功",200,"");
        } catch (Exception e) {
            e.printStackTrace();

            resultData = new ResultData<>(false,"操作异常",400,"");
        }

        return resultData;
    }

    @GetMapping("/getCraneWorkMinTm")
    public ResultData<List<Map<String,Object>>> getCraneWorkMinTm(){
        ResultData<List<Map<String,Object>>> resultData = null;

        Map<String,Object> param = new HashMap<>();

        try {
            Map<String,Map<String,Object>> minTms = craneStatusService.getMinTmForInsert(); //获取所有最小时长

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

            List<Map<String,Object>> rows = craneStatusService.checkExistOfMinTm(null);

            resultData = new ResultData<>(true,"操作成功",200,rows);
        } catch (Exception e) {
            e.printStackTrace();

            resultData = new ResultData<>(false,"操作异常",400,null);
        }

        return resultData;
    }

    @GetMapping("/getCraneTimeCensus")
    public ResultData<List<CraneTimeCensus>> getCraneTimeCensus(){
        ResultData<List<CraneTimeCensus>> resultData = null;

        List<CraneTimeCensus> rows = null;

        try {
            rows = craneStatusService.getUpDownTimeForInsert();

            for(CraneTimeCensus row:rows){
                craneTimeCensusService.saveOrUpdate(row);
            }

            resultData = new ResultData<>(true,"操作成功",200,rows);
        } catch (Exception e) {
            e.printStackTrace();

            resultData = new ResultData<>(false,e.getMessage(),400,rows);
        }

        return resultData;
    }
}
