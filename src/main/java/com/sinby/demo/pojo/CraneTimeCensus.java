package com.sinby.demo.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * @author：sinby
 * @Date: 2022/09/20 10:29
 * @Description: XXXX
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("CRANE_TIME_CENSUS")
@Alias("cranetimecensus")
public class CraneTimeCensus {

    @TableId
    BigDecimal cmdno;
    String crno;
    String ldno;
    String startLoc;
    String destLoc;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    Timestamp arriveTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    Timestamp upTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    Timestamp leaveTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    Timestamp downTime;

    BigDecimal workTm;
    BigDecimal prepareTm;
    BigDecimal upTm;
    BigDecimal avoidTm;

}
