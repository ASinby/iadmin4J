package com.sinby.iadmin4J.controller;

import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.sinby.iadmin4J.entity.MdRhCurrentEntity;
import com.sinby.iadmin4J.pojo.ResultData;
import com.sinby.iadmin4J.service.MdRhCurrentService;
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
    MdRhCurrentService mdRhCurrentService;

    @ApiOperation( value = "通过传入的工位号，获取当前炉次基本信息" )
    @ApiImplicitParams({@ApiImplicitParam(name = "station1", value = "工位号")})
    @GetMapping("/getBaseInfo")
    public ResultData getBaseInfo(@RequestParam String station1) {

        ResultData result = new ResultData();
        MdRhCurrentEntity re = new MdRhCurrentEntity();
        try {
            QueryWrapper<MdRhCurrentEntity> queryWrapper = new QueryWrapper();
            queryWrapper.eq("STATION1",station1);
            re = mdRhCurrentService.getOne(queryWrapper);

            result.setCode(200);
            if ( re == null )
                result.setMessage("暂无数据！");
            else {
                // 将yyyyMMddHHmmss  ===》 yyyy-MM-dd HH:mm:ss 待完成
                String treatStartTm = re.getTreatStartTm();
                String treatEndTm = re.getTreatEndTm();
                if (treatStartTm != null && treatStartTm.equals("") && treatStartTm.isEmpty())
                    re.setTreatStartTm(DateUtil.format(DateUtil.parse(re.getTreatStartTm()),"yyyy-MM-dd HH:mm:ss"));
                if (treatEndTm != null && treatEndTm.equals("") && treatEndTm.isEmpty())
                    re.setTreatEndTm(DateUtil.format(DateUtil.parse(re.getTreatEndTm()),"yyyy-MM-dd HH:mm:ss"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            result.setCode(500);
            result.setMessage(e.getMessage());
        }
        result.setData(re);

        return result;
    }

    @ApiOperation(value = "修改并计算最新炉次信息")
    @ApiImplicitParams({@ApiImplicitParam(name = "mdRhCurrentEntity", value = "最新炉次实体类")})
    @PutMapping("/doCalc")
    public ResultData doCalc(@RequestBody MdRhCurrentEntity mdRhCurrentEntity) {
        ResultData resultData = new ResultData();

        QueryWrapper queryWrapper = new QueryWrapper();
        UpdateWrapper updateWrapper = new UpdateWrapper();

        try {
            // 1、查询版本号是否一致
            queryWrapper.eq("STATION1",mdRhCurrentEntity.getStation1());
            queryWrapper.eq("VERSION1",mdRhCurrentEntity.getVersion1());
            int count = mdRhCurrentService.count(queryWrapper);

            // 若版本号不一致，则返回异常
            if (count <= 0) {
                resultData.setCode(500);
                resultData.setMessage("提交数据不一致，请刷新后，再操作！");
                return resultData;
            }

            // 2、修改数据
            boolean result = mdRhCurrentService.updateById(mdRhCurrentEntity);
            if (!result) {
                resultData.setCode(500);
                resultData.setMessage("修改异常，请刷新后，再操作！");
                return resultData;
            }
            resultData.setCode(200);
            resultData.setMessage("开始计算");
        } catch (Exception e) {
            e.printStackTrace();

            resultData.setCode(500);
            resultData.setMessage(e.toString());
        }

        return resultData;
    }
}
