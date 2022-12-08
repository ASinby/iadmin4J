package com.sinby.iadmin4J.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sinby.iadmin4J.entity.MdAlloySetEntity;
import com.sinby.iadmin4J.entity.MdBunkerInfoEntity;
import com.sinby.iadmin4J.entity.MdRhCurrentEntity;
import com.sinby.iadmin4J.entity.MdWasteGasEntity;
import com.sinby.iadmin4J.pojo.ResultData;
import com.sinby.iadmin4J.service.MdAlloySetService;
import com.sinby.iadmin4J.service.MdBunkerInfoService;
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
 * @Date: 2022/12/4 16:08
 * @Description: XXX
 */
@Api(description = "合金最小模型页面接口")
@RestController
@RequestMapping("/alloymin")
public class AlloyMinController {

    @Autowired
    MdRhCurrentService mdRhCurrentService;
    @Autowired
    MdAlloySetService mdAlloySetService;
    @Autowired
    MdBunkerInfoService mdBunkerInfoService;

    @ApiOperation("获取钢水成分元素信息，通过工位号")
    @ApiImplicitParams({@ApiImplicitParam(name = "station1",value = "工位号")})
    @GetMapping("/getElementInfo")
    public ResultData getElementInfo(@RequestParam String station1) {
        ResultData resultData = new ResultData();

        QueryWrapper queryWrapper = new QueryWrapper();

        MdRhCurrentEntity mdRhCurrentEntity = new MdRhCurrentEntity();
        List<MdAlloySetEntity> rows = new ArrayList<>();

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
            queryWrapper.orderByAsc("FLAG");
            rows = mdAlloySetService.list(queryWrapper);

            resultData.setCode(200);
            if (rows != null && rows.size() > 0)
                resultData.setMessage("钢水元素成分信息加载成功！");
            else
                resultData.setMessage("暂无 "+mdRhCurrentEntity.getPlno()+" 计划的钢水元素成分信息！");
        } catch (Exception e) {
            e.printStackTrace();

            resultData.setCode(500);
            resultData.setMessage(e.toString());
        }

        resultData.setData(rows);

        return resultData;
    }

    @ApiOperation("获取合金计算结果信息，通过工位号")
    @ApiImplicitParams({@ApiImplicitParam(name = "station1",value = "工位号")})
    @GetMapping("/getGasFlowRate")
    public ResultData getGasFlowRate(@RequestParam String station1) {
        ResultData resultData = new ResultData();

        QueryWrapper queryWrapper = new QueryWrapper();

        MdRhCurrentEntity mdRhCurrentEntity = new MdRhCurrentEntity();
        List<MdBunkerInfoEntity> rows = new ArrayList<>();

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
            rows = mdBunkerInfoService.list(queryWrapper);

            resultData.setCode(200);
            if (rows != null && rows.size() > 0)
                resultData.setMessage("合金计算结果加载成功！");
            else
                resultData.setMessage("暂无 "+mdRhCurrentEntity.getPlno()+" 计划的合金计算结果！");
        } catch (Exception e) {
            e.printStackTrace();

            resultData.setCode(500);
            resultData.setMessage(e.toString());
        }

        resultData.setData(rows);

        return resultData;
    }
}
