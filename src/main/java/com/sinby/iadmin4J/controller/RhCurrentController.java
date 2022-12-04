package com.sinby.iadmin4J.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.sinby.iadmin4J.pojo.ResultData;
import com.sinby.iadmin4J.pojo.MdRhCurrent;
import com.sinby.iadmin4J.service.RhCurrentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author：sinby
 * @Date: 2022/12/3 14:25
 * @Description: XXX
 */
@Api(description = "RH当前最新状态表")
@RestController
public class RhCurrentController {

    @Autowired
    RhCurrentService rhCurrentService;

    @ApiOperation( value = "通过传入的工位号，获取当前炉次基本信息" )
    @ApiImplicitParams({@ApiImplicitParam(name = "station1", value = "工位号")})
    @GetMapping("/getBaseInfo")
    public ResultData getBaseInfo(@RequestParam String station1) {

        ResultData result = new ResultData();
        MdRhCurrent re = new MdRhCurrent();
        try {
            QueryWrapper<MdRhCurrent> queryWrapper = new QueryWrapper();
            queryWrapper.eq("station1",station1);
            re = rhCurrentService.getOne( queryWrapper );

            result.setCode(200);
            result.setMessage("");
        } catch (Exception e) {
            e.printStackTrace();
            result.setCode(500);
            result.setMessage(e.getMessage());
        }
        result.setData(re);

        return result;
    }

    @ApiOperation(value = "修改基本信息，通过工位号")
    @ApiImplicitParams({@ApiImplicitParam(name = "mdRhCurrent", value = "实体类")})
    @PutMapping("/updateBaseInfo")
    public ResultData updateBaseInfo(@RequestBody MdRhCurrent mdRhCurrent) {
        ResultData resultData = new ResultData();

        UpdateWrapper updateWrapper = new UpdateWrapper();

        try {
            updateWrapper.eq("STATION1", mdRhCurrent.getStation1());
            updateWrapper.set("BLOW_O2_MODE",mdRhCurrent.getBlowO2Mode());
            updateWrapper.set("SET_O2",mdRhCurrent.getSetO2());

            boolean result = rhCurrentService.update(updateWrapper);

            String msg = "";
            if (result) msg = "修改成功！";
            else msg = "修改失败！";

            resultData.setCode(200);
            resultData.setMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();

            resultData.setCode(500);
            resultData.setMessage(e.getMessage());
        }

        return resultData;
    }
}
