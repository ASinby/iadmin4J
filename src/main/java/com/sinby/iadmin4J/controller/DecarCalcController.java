package com.sinby.iadmin4J.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sinby.iadmin4J.entity.MdOutCoxyEntity;
import com.sinby.iadmin4J.entity.MdRhCurrentEntity;
import com.sinby.iadmin4J.entity.MdWasteGasEntity;
import com.sinby.iadmin4J.pojo.ResultData;
import com.sinby.iadmin4J.service.MdOutCoxyService;
import com.sinby.iadmin4J.service.MdRhCurrentService;
import com.sinby.iadmin4J.service.MdWasteGasService;
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
 * @Date: 2022/12/4 14:53
 * @Description: XXX
 */
@Api(description = "动态脱碳计算页面接口")
@RestController
@RequestMapping("/decarcalc")
public class DecarCalcController {

    @Autowired
    MdRhCurrentService mdRhCurrentService;
    @Autowired
    MdWasteGasService mdWasteGasService;
    @Autowired
    MdOutCoxyService mdOutCoxyService;

    @ApiOperation("获取废气流量曲线图数据接口，通过工位号")
    @ApiImplicitParams({@ApiImplicitParam(name = "station1",value = "工位号")})
    @GetMapping("/getGasFlowRate")
    public ResultData getGasFlowRate(@RequestParam String station1) {
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

            // 2、根据计划号或是处理号查询废气信息
            queryWrapper.clear();
            queryWrapper.eq("PLNO",mdRhCurrentEntity.getPlno());
            queryWrapper.eq("TREAT_NO",mdRhCurrentEntity.getTreatno());
            queryWrapper.orderByAsc("TM");
            rows = mdWasteGasService.list(queryWrapper);

            resultData.setCode(200);
            if (rows != null && rows.size() > 0)
                resultData.setMessage("废气流量数据加载成功！");
            else
                resultData.setMessage("暂无 "+mdRhCurrentEntity.getPlno()+" 计划的废气流量信息！");
        } catch (Exception e) {
            e.printStackTrace();

            resultData.setCode(500);
            resultData.setMessage(e.toString());
        }

        resultData.setData(rows);

        return resultData;
    }

    @ApiOperation("获取脱碳量曲线图数据接口，通过工位号")
    @ApiImplicitParams({@ApiImplicitParam(name = "station1",value = "工位号")})
    @GetMapping("/getOutCoxy")
    public ResultData getOutCoxy(@RequestParam String station1) {
        ResultData resultData = new ResultData();

        QueryWrapper queryWrapper = new QueryWrapper();

        MdRhCurrentEntity mdRhCurrentEntity = new MdRhCurrentEntity();
        List<MdOutCoxyEntity> rows = new ArrayList<>();

        try {
            // 1、根据工位号，查询出当前最新一炉信息，如计划号或是处理号
            queryWrapper.eq("STATION1",station1);
            mdRhCurrentEntity = mdRhCurrentService.getOne(queryWrapper);

            if (mdRhCurrentEntity == null) {
                resultData.setCode(500);
                resultData.setMessage("暂无炉次信息");

                return resultData;
            }

            // 2、根据计划号或是处理号查询废气信息
            queryWrapper.clear();
            queryWrapper.eq("PLNO",mdRhCurrentEntity.getPlno());
            queryWrapper.eq("TREAT_NO",mdRhCurrentEntity.getTreatno());
            queryWrapper.orderByAsc("TM");
            rows = mdOutCoxyService.list(queryWrapper);

            resultData.setCode(200);
            if (rows != null && rows.size() > 0)
                resultData.setMessage("脱碳量数据加载成功！");
            else
                resultData.setMessage("暂无 "+mdRhCurrentEntity.getPlno()+" 计划的脱碳量信息！");
        } catch (Exception e) {
            e.printStackTrace();

            resultData.setCode(500);
            resultData.setMessage(e.toString());
        }

        resultData.setData(rows);

        return resultData;
    }
}
