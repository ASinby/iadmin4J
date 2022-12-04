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
 * @Date: 2022/12/3 10:51
 * @Description: 钢水成分表
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Alias("alloySet")
public class MdAlloySet {
    String flag;    //1:元素下限  2:元素目标  3:元素上限  4:成分最新  5:目标调整  6:标准收得率
    String plno;    //计划号
    String stno;    //出钢记号
    String htno;    //炉号
    String treatNo; //处理号
    String postCode;    //工位号
    String sampleNo;    //取样号
    String anaTm;
    String cVal;
    String siVal;
    String mnVal;
    String pVal;
    String sVal;
    String mgVal;
    String crVal;
    String niVal;
    String moVal;
    String cuVal;
    String alVal;
    String tiVal;
    String vVal;
    String nbVal;
    String wVal;
    String bVal;
    String caVal;
    String sbVal;
    String asVal;
    String snVal;
    String pbVal;
    String biVal;
    String ceVal;
    String coVal;
    String nVal;

    @JsonFormat(pattern = "HH:mm",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    Timestamp tm;
}
