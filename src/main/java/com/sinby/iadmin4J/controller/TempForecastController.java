package com.sinby.iadmin4J.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sinby.iadmin4J.entity.*;
import com.sinby.iadmin4J.pojo.ResultData;
import com.sinby.iadmin4J.service.MdMataddRhService;
import com.sinby.iadmin4J.service.MdOutAlloyService;
import com.sinby.iadmin4J.service.MdOutTempService;
import com.sinby.iadmin4J.service.MdRhCurrentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author：sinby
 * @Date: 2022/12/4 16:58
 * @Description: XXX
 */
@Api(description = "温度模型预测页面接口")
@RestController
@RequestMapping("/tempforecast")
public class TempForecastController {

    @Autowired
    MdRhCurrentService mdRhCurrentService;
    @Autowired
    MdMataddRhService mdMataddRhService;
    @Autowired
    MdOutTempService mdOutTempService;
    @Autowired
    MdOutAlloyService mdOutAlloyService;

    @ApiOperation("获取吹氧信息，通过工位号")
    @ApiImplicitParams({@ApiImplicitParam(name = "station1",value = "工位号")})
    @GetMapping("/getBlastOxyInfo")
    public ResultData getBlastOxyInfo(@RequestParam String station1) {
        ResultData resultData = new ResultData();

        QueryWrapper queryWrapper = new QueryWrapper();

        MdRhCurrentEntity mdRhCurrentEntity = new MdRhCurrentEntity();
        List<MdWasteGasEntity> rows = new ArrayList<>();

        try {
            // 1、根据工位号，查询出当前最新一炉信息，如计划号或是处理号
            queryWrapper.eq("STATION1",station1);
            mdRhCurrentEntity = mdRhCurrentService.getOne(queryWrapper);

            if (mdRhCurrentEntity == null) {
                resultData.setCode(500);
                resultData.setMessage("暂无炉次信息");

                return resultData;
            }

            // 2、
            queryWrapper.clear();
            queryWrapper.eq("PLNO",mdRhCurrentEntity.getPlno());
            queryWrapper.eq("TREAT_NO",mdRhCurrentEntity.getTreatno());
            queryWrapper.orderByAsc("TM");
            rows = null;

            resultData.setCode(200);
            if (rows != null && rows.size() > 0)
                resultData.setMessage("吹氧信息加载成功！");
            else
                resultData.setMessage("暂无 "+mdRhCurrentEntity.getPlno()+" 计划的吹氧信息！");
        } catch (Exception e) {
            e.printStackTrace();

            resultData.setCode(500);
            resultData.setMessage(e.toString());
        }

        resultData.setData(rows);

        return resultData;
    }

    @ApiOperation("获取合金信息，通过工位号")
    @ApiImplicitParams({@ApiImplicitParam(name = "station1",value = "工位号")})
    @GetMapping("/getAlloyInfo")
    public ResultData getAlloyInfo(@RequestParam String station1) {
        ResultData resultData = new ResultData();

        QueryWrapper queryWrapper = new QueryWrapper();

        MdRhCurrentEntity mdRhCurrentEntity = new MdRhCurrentEntity();
        List<MdMataddRhEntity> rows = new ArrayList<>();

        try {
            // 1、根据工位号，查询出当前最新一炉信息，如计划号或是处理号
            queryWrapper.eq("STATION1",station1);
            mdRhCurrentEntity = mdRhCurrentService.getOne(queryWrapper);

            if (mdRhCurrentEntity == null) {
                resultData.setCode(500);
                resultData.setMessage("暂无炉次信息");

                return resultData;
            }

            // 2、
            queryWrapper.clear();
            queryWrapper.eq("PLNO",mdRhCurrentEntity.getPlno());
            queryWrapper.eq("TREAT_NO",mdRhCurrentEntity.getTreatno());
            queryWrapper.orderByAsc("TM");
            rows = mdMataddRhService.list(queryWrapper);

            resultData.setCode(200);
            if (rows != null && rows.size() > 0)
                resultData.setMessage("合金信息加载成功！");
            else
                resultData.setMessage("暂无 "+mdRhCurrentEntity.getPlno()+" 计划的合金信息！");
        } catch (Exception e) {
            e.printStackTrace();

            resultData.setCode(500);
            resultData.setMessage(e.toString());
        }

        resultData.setData(rows);

        return resultData;
    }

    @ApiOperation("获取温度趋势数据，通过工位号")
    @ApiImplicitParams({@ApiImplicitParam(name = "station1",value = "工位号")})
    @GetMapping("/getTempData")
    public ResultData getTempData(@RequestParam String station1) {
        ResultData resultData = new ResultData();

        QueryWrapper queryWrapper = new QueryWrapper();

        MdRhCurrentEntity mdRhCurrentEntity = new MdRhCurrentEntity();
        List<MdOutTempEntity> rows = new ArrayList<>();

        try {
            // 1、根据工位号，查询出当前最新一炉信息，如计划号或是处理号
            queryWrapper.eq("STATION1",station1);
            mdRhCurrentEntity = mdRhCurrentService.getOne(queryWrapper);

            if (mdRhCurrentEntity == null) {
                resultData.setCode(500);
                resultData.setMessage("暂无炉次信息");

                return resultData;
            }

            // 2、
            queryWrapper.clear();
            queryWrapper.eq("PLNO",mdRhCurrentEntity.getPlno());
            queryWrapper.eq("TREAT_NO",mdRhCurrentEntity.getTreatno());
            queryWrapper.orderByAsc("ID");
            rows = mdOutTempService.list(queryWrapper);

            resultData.setCode(200);
            if (rows != null && rows.size() > 0)
                resultData.setMessage("温度趋势数据加载成功！");
            else
                resultData.setMessage("暂无 "+mdRhCurrentEntity.getPlno()+" 计划的温度趋势数据！");
        } catch (Exception e) {
            e.printStackTrace();

            resultData.setCode(500);
            resultData.setMessage(e.toString());
        }

        resultData.setData(rows);

        return resultData;
    }

    @ApiOperation("获取计划投入合金信息，通过工位号")
    @ApiImplicitParams({@ApiImplicitParam(name = "station1",value = "工位号")})
    @GetMapping("/getAlloyInfoOfPlan")
    public ResultData getAlloyInfoOfPlan(@RequestParam String station1) {
        ResultData resultData = new ResultData();

        QueryWrapper queryWrapper = new QueryWrapper();

        MdRhCurrentEntity mdRhCurrentEntity = new MdRhCurrentEntity();
        List<MdOutAlloyEntity> rows = new ArrayList<>();

        try {
            // 1、根据工位号，查询出当前最新一炉信息，如计划号或是处理号
            queryWrapper.eq("STATION1",station1);
            mdRhCurrentEntity = mdRhCurrentService.getOne(queryWrapper);

            if (mdRhCurrentEntity == null) {
                resultData.setCode(500);
                resultData.setMessage("暂无炉次信息");

                return resultData;
            }

            // 2、
            queryWrapper.clear();
            queryWrapper.eq("TREAT_NO",mdRhCurrentEntity.getTreatno());
            queryWrapper.orderByAsc("TM");
            rows = mdOutAlloyService.list(queryWrapper);

            resultData.setCode(200);
            if (rows != null && rows.size() > 0)
                resultData.setMessage("计划合金投入信息加载成功！");
            else
                resultData.setMessage("暂无 "+mdRhCurrentEntity.getPlno()+" 计划的计划合金投入信息！");
        } catch (Exception e) {
            e.printStackTrace();

            resultData.setCode(500);
            resultData.setMessage(e.toString());
        }

        resultData.setData(rows);

        return resultData;
    }
}
