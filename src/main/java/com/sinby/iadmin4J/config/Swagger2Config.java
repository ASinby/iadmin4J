package com.sinby.iadmin4J.config;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @author：sinby
 * @Date: 2022/11/20 17:05
 * @Description: 使用swagger生产接口文档    https://www.jianshu.com/p/079860904b78
 */
@Api(value = "/api", description = "swagger示例接口", tags = "example")
@RestController
@RequestMapping(value = "/api", produces = {"application/json"})
public class Swagger2Config {

    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select().apis(RequestHandlerSelectors.any())   //api的配置路径
                .paths(PathSelectors.any()) //扫描路径选择
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("title") //文档标题
                .description("description") //接口概述
                .version("1.1") //版本号
                .termsOfServiceUrl(String.format("url"))    //服务的域名
                .build();
    }
}
