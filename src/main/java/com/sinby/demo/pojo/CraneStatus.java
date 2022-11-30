package com.sinby.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * @author：sinby
 * @Date: 2022/09/15 14:04
 * @Description: 行车状态表，部分数据字段
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Alias("CraneStatus")
public class CraneStatus {

    BigDecimal seq; //同跨行车序号
    String gwd; //工位点
    String gwdmc;   //工位点名称
    BigDecimal wlwzX;   //大车x坐标
    BigDecimal wlwzY;   //小车y坐标
    BigDecimal wlwzZ;   //钩子z坐标
    BigDecimal weight;  //重量
    String loc; //位置
    String locDesc; //位置描述
    String ldno;    //包号
    String ldStatus;    //包存在标志
    String tm;   //时间
}
