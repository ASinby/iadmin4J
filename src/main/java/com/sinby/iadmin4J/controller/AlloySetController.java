package com.sinby.iadmin4J.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sinby.iadmin4J.dao.RhCurrentDao;
import com.sinby.iadmin4J.pojo.MdAlloySet;
import com.sinby.iadmin4J.pojo.MdRhCurrent;
import com.sinby.iadmin4J.pojo.ResultData;
import com.sinby.iadmin4J.service.AlloySetService;
import com.sinby.iadmin4J.service.RhCurrentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author：sinby
 * @Date: 2022/12/3 16:40
 * @Description: XXX
 */
@Api(description = "钢水成分表")
@RestController
public class AlloySetController {

    @Autowired
    AlloySetService alloySetService;
    @Autowired
    RhCurrentService rhCurrentService;

    @ApiOperation(value = "获取当前炉次元素成分")
    @ApiImplicitParams({@ApiImplicitParam(name = "station1",value = "工位号")})
    @GetMapping("/getElementInfo")
    public ResultData getElementInfo(@RequestParam String station1) {

        ResultData resultData = new ResultData();
        List<MdAlloySet> rows = new ArrayList<>();

        MdRhCurrent mdRhCurrent = new MdRhCurrent();

        QueryWrapper queryWrapper = new QueryWrapper();
        try {
            // Get the latest plan of station
            queryWrapper.eq("station1",station1);
            mdRhCurrent = rhCurrentService.getOne(queryWrapper);

            // Get element information of the plan
            queryWrapper.clear();
            queryWrapper.eq("plno",mdRhCurrent.getPlno());
            queryWrapper.orderByAsc("flag");
            rows = alloySetService.list(queryWrapper);

            resultData.setCode(200);
        } catch (NullPointerException ne) {
            ne.printStackTrace();

            resultData.setCode(500);
            resultData.setMessage(ne.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        resultData.setData(rows);

        return resultData;
    }
}
