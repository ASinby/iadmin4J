package com.sinby.iadmin4J.controller;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.NumberUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.sinby.iadmin4J.entity.MdAlloySetEntity;
import com.sinby.iadmin4J.entity.MdBunkerInfoEntity;
import com.sinby.iadmin4J.entity.MdRhCurrentEntity;
import com.sinby.iadmin4J.pojo.ResultData;
import com.sinby.iadmin4J.service.MdAlloySetService;
import com.sinby.iadmin4J.service.MdBunkerInfoService;
import com.sinby.iadmin4J.service.MdRhCurrentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    @GetMapping("/getAlloyCalcResult")
    public ResultData getAlloyCalcResult(@RequestParam String station1) {
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

    @ApiOperation("修改元素信息")
    @ApiImplicitParams({@ApiImplicitParam(name = "mdAlloySetEntity",value = "元素设定实体类")})
    @PutMapping("/updateElementInfo")
    public ResultData updateElementInfo(@RequestBody MdAlloySetEntity mdAlloySetEntity) {
        ResultData resultData = new ResultData();

        List<MdAlloySetEntity> rows = new ArrayList<>();
        QueryWrapper queryWrapper = new QueryWrapper();
        UpdateWrapper updateWrapper = new UpdateWrapper();

        try {
            // 1、修改
            // 1.1校验版本
            queryWrapper.eq("PLNO",mdAlloySetEntity.getPlno());
            queryWrapper.eq("FLAG",mdAlloySetEntity.getFlag());
            queryWrapper.eq("VERSION1",mdAlloySetEntity.getVersion1());

            int count = mdAlloySetService.count(queryWrapper);
            if (count <= 0) {
                resultData.setCode(500);
                resultData.setMessage("提交数据不一致，请刷新后，再操作！");
                return resultData;
            }
            // 1.2update
            boolean result = mdAlloySetService.updateById(mdAlloySetEntity);
            if (!result) {
                resultData.setCode(500);
                resultData.setMessage("修改异常，请刷新后，再操作！");
                return resultData;
            }

            // 2、返回最新
            queryWrapper.clear();
            queryWrapper.eq("PLNO",mdAlloySetEntity.getPlno());
            queryWrapper.orderByAsc("FLAG");
            rows = mdAlloySetService.list(queryWrapper);

            resultData.setCode(200);
            resultData.setMessage("修改成功！");
        } catch (Exception e) {
            e.printStackTrace();

            resultData.setCode(500);
            resultData.setMessage(e.toString());
        }
        resultData.setData(rows);

        return resultData;
    }

    @ApiOperation("修改合金计算结果")
    @ApiImplicitParams({@ApiImplicitParam(name = "map",value = "修改参数Map")})
    @PutMapping("/updateAlloyCalcResult")
    public ResultData updateAlloyCalcResult(@RequestBody Object str) {
        ResultData resultData = new ResultData();

        try {
            // 1、Object转Map
            Map<String, Object> row = BeanUtil.beanToMap(str);
            Map<String, Object> oldRow = BeanUtil.beanToMap(row.get("oldRow"));

            // 2、获取修改值
            List<Map<String,Object>> params = new ArrayList<>();
            for (String key : row.keySet()) {
                if ( key.equals("rowsHeader") || key.equals("edit") || key.equals("oldRow") || key.equals("treatNo") || key.equals("fieldName") )
                    continue;
                if (  oldRow.get(key) != null && row.get(key).equals(oldRow.get(key)) )
                    continue;
                Map<String,Object> param = new HashMap<>();
                for (String kk: row.keySet()) {
                    if ( !kk.equals("rowsHeader") && !kk.equals("edit") && !kk.equals("oldRow") ) {
                        if ( kk.equals("treatNo") ) {  // 处理号
                            param.put("treatNo",row.get(kk));
                        }else if ( kk.equals("fieldName") ) {  // 修改字段 ifok-IFOK 或者 matSetw-MAT_SETW
                            if (row.get(kk).equals("ifok") || row.get(kk).equals("matSetw")) {
                                String fieldName = "IFOK";
                                if (row.get(kk).equals("matSetw"))
                                    fieldName = "MAT_SETW";
                                param.put("fieldName",fieldName);
                            }else {
                                resultData.setCode(500);
                                resultData.setMessage("参数异常");

                                return resultData;
                            }
                        }else if ( key.equals(kk) ) {
                            Object setVal = row.get(key);
                            if (setVal == "" )
                                setVal = null;
                            if ( setVal != null && !NumberUtil.isNumber(String.valueOf(setVal))) {
                                resultData.setCode(500);
                                resultData.setMessage("请输入正确格式！请检查料仓号"+key+"的值，"+setVal);
                                return resultData;
                            }
                            param.put("bunkerNo",key);
                            param.put("setVal",setVal);
                        }
                    }
                }
                params.add(param);
            }
            System.out.println( params.toString() );

            // 3、修改
            for ( Map<String,Object> param:params ) {
                boolean result = mdBunkerInfoService.updateByBT(param);
                if (!result) {
                    resultData.setCode(500);
                    resultData.setMessage("修改异常，请稍后再试。");
                    return resultData;
                }
            }
            resultData.setCode(200);
            resultData.setMessage("修改成功");
        } catch (Exception e) {
            e.printStackTrace();

            resultData.setCode(500);
            resultData.setMessage(e.toString());
        }
        return resultData;
    }

    @ApiOperation("修改脱氧铝、加热铝")
    @ApiImplicitParams({@ApiImplicitParam(name = "deoAl",value = "脱氧铝"),@ApiImplicitParam(name = "heatAl",value = "加热铝")})
    @PutMapping("/updateAlNums")
    public ResultData updateAlNums(@RequestParam String deoAl,@RequestParam String heatAl) {
        ResultData resultData = new ResultData();
        resultData.setCode(500);
        resultData.setMessage("暂未开发");
        return resultData;
    }
}
