package com.sinby.iadmin4J.controller;

import com.sinby.iadmin4J.pojo.ResultData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author：sinby
 * @Date: 2022/12/5 15:46
 * @Description: XXX
 */
@Api(description = "用户登录接口")
@RestController
public class UserController {

    @ApiOperation("登录用户信息校验接口")
    @ApiImplicitParams({@ApiImplicitParam(name = "username",value = "用户名"),@ApiImplicitParam(name = "password",value = "密码")})
    @GetMapping("/login")
    public ResultData login(@RequestParam String username, @RequestParam String password) {

        System.out.println("用户名："+username+" 密码："+password);

        ResultData resultData = new ResultData();
        Map<String,String> info = new HashMap<>();
        info.put("token","token");

        resultData.setCode(200);
        resultData.setMessage("登录成功");
        resultData.setData(info);

        return resultData;
    }

    @ApiOperation("获取登录用户信息")
    @GetMapping("/getUserInfo")
    public ResultData getUserInfo() {

        ResultData resultData = new ResultData();
        Map<String,Object> info = new HashMap<>();

        // 角色
        String[] roles = new String[1];
        roles[0] = "admin";

        info.put("id",9527);
        info.put("avatar","");
        info.put("name","宋小哈");
        info.put("phone","15688888888");
        info.put("email","sinby857@126.com");
        info.put("identity","");
        info.put("roles",roles);

        resultData.setCode(200);
        resultData.setMessage("");
        resultData.setData(info);

        return resultData;
    }
}
