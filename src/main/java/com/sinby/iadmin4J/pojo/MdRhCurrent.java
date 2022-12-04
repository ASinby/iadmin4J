package com.sinby.iadmin4J.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Timestamp;

/**
 * @author：sinby
 * @Date: 2022/12/3 13:55
 * @Description: RH当前最新状态
 */

/**
 * 命名规则 驼峰式命名法 每个峰，表示用下划线分割的
 * 类名 MD_RH_CURRENT ==> mdRhCurrent
 * 字段名 同理
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Alias("rhCurrent")
public class MdRhCurrent {
    String station1;    //工位号
    String treatno;     //处理号
    String stno;        //出钢记号
    String plno;        //计划号
    String pono;        //制造命令号
    String treatStartTm;//处理开始时间
    String aimOxp;      //目标OXP
    Integer setO2;      //设定吹氧量
    String blowO2Mode;  //吹氧模式 0不吹氧  1使用设定值  2使用预报值
    Timestamp runTm;    //程序开始时间
    Integer forecastO2; //预报吹氧量
    Integer treatSpan;  //预计处理时长
    Integer killingC;   //镇静C
    String tips;        //模型输出提醒
    String preC;        //处理前C%
    String preOxp;      //处理前OXP%
    String aimC;        //目标C%
    String steelTemp;   //钢水温度
    String steelWeight; //钢水重量
    String stStatus;    //钢包状态
    String treatEndTm;  //处理结束时间
    String vacTankTemp; //当前真空槽温度
    String vacTankTempAdd;  //真空槽补正温度
    String vacTankAlAdd;    //真空槽烘烤Al补正量
    String alloyAddWeight;  //合金增重
    String alloyAllCost ;   //合金总成本

    @JsonFormat(pattern = "HH:mm",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    Timestamp tm;           //时间
}
