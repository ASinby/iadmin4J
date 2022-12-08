package com.sinby.iadmin4J;

import cn.hutool.core.date.DateUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Iadmin4JApplicationTests {

    @Test
    void contextLoads() {
        String tm = "20221120145601";

        System.out.println(DateUtil.parse(tm));
    }

}
