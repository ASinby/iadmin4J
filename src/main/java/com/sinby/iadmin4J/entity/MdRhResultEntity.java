package com.sinby.iadmin4J.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * RH 实绩
 * 
 * @author sinby
 * @date 2022-12-04 12:11:25
 */
@Data
@TableName("MD_RH_RESULT")
public class MdRhResultEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private String productDate;
	/**
	 * 
	 */
	private String rhDeviceNo;
	/**
	 * 
	 */
	private String plno;
	/**
	 * 
	 */
	private String pono;
	/**
	 * 
	 */
	private String htno;
	/**
	 * 
	 */
	private String rhTreatNo;
	/**
	 * 
	 */
	private String stno;
	/**
	 * 
	 */
	private String stnoDesc;
	/**
	 * 
	 */
	private String refineTimes;
	/**
	 * 
	 */
	private String shift1;
	/**
	 * 
	 */
	private String group1;
	/**
	 * 
	 */
	private String ladleArriveTm;
	/**
	 * 
	 */
	private String treatStartTm;
	/**
	 * 
	 */
	private String treatEndTm;
	/**
	 * 
	 */
	private String ladleLeaveTm;
	/**
	 * 
	 */
	private String cycleArCosum;
	/**
	 * 
	 */
	private String cycleN2Cosum;
	/**
	 * 
	 */
	private String bottomArCosum;
	/**
	 * 
	 */
	private String bottomN2Cosum;
	/**
	 * 
	 */
	private String h2oCosum;
	/**
	 * 
	 */
	private String o2Cosum;
	/**
	 * 
	 */
	private String lnqlqshl;
	/**
	 * 
	 */
	private String jxlqshl;
	/**
	 * 
	 */
	private String moltenWeight;
	/**
	 * 
	 */
	private String residuThick;
	/**
	 * 
	 */
	private String leaveTempTm;
	/**
	 * 
	 */
	private String arriveTemp;
	/**
	 * 
	 */
	private String leaveTemp;
	/**
	 * 
	 */
	private String endOxy;
	/**
	 * 
	 */
	private String endH2Tm;
	/**
	 * 
	 */
	private String endH2Ratio;
	/**
	 * 
	 */
	private String endO2Ratio;
	/**
	 * 
	 */
	private String totalTmspan;
	/**
	 * 
	 */
	private String vacuoStartTm;
	/**
	 * 
	 */
	private String vacuoEndTm;
	/**
	 * 
	 */
	private String vacuoTmspan;
	/**
	 * 
	 */
	private String vacuoHighTmspan;
	/**
	 * 
	 */
	private String ctqsj;
	/**
	 * 
	 */
	private String minVacuo;
	/**
	 * 
	 */
	private String oxyLanceNo;
	/**
	 * 
	 */
	private String oxyLanceAge;
	/**
	 * 
	 */
	private String oxyLanceCosum;
	/**
	 * 
	 */
	private String oxyTmspan;
	/**
	 * 
	 */
	private String ldno;
	/**
	 * 
	 */
	private String softBlowTmspan;
	/**
	 * 
	 */
	private String treatTimes;
	/**
	 * 
	 */
	private String ldnoStatus;
	/**
	 * 
	 */
	private String beforeWsTemp;
	/**
	 * 
	 */
	private String afterWsTemp;
	/**
	 * 
	 */
	private String stationNo;
	/**
	 * 
	 */
	private String oper;
	/**
	 * 
	 */
	private String gbLife;
	/**
	 * 
	 */
	private String gbType;
	/**
	 * 
	 */
	private String oxyStartTm;
	/**
	 * 
	 */
	private String oxyEndTm;
	/**
	 * 
	 */
	private String vacuoEndTemp;
	/**
	 * 
	 */
	private String procAdjTem;
	/**
	 * 
	 */
	private String preSteelWeight;
	/**
	 * 
	 */
	private String preOxy;
	/**
	 * 
	 */
	private String rwgNo;
	/**
	 * 
	 */
	private String rwgLife;
	/**
	 * 
	 */
	private String topTankNo;
	/**
	 * 
	 */
	private String topTankLife;
	/**
	 * 
	 */
	private String botTankNo;
	/**
	 * 
	 */
	private String botTankLife;
	/**
	 * 
	 */
	private String preSteelTemp;
	/**
	 * 
	 */
	private String preZhaThick;
	/**
	 * 
	 */
	private String endZhaWeight;
	/**
	 * 
	 */
	private String preZhaWeight;
	/**
	 * 
	 */
	private String wsStartTm;
	/**
	 * 
	 */
	private String wsEndTm;
	/**
	 * 
	 */
	private String wsType1;
	/**
	 * 
	 */
	private String wsType2;
	/**
	 * 
	 */
	private String wsLength1;
	/**
	 * 
	 */
	private String wsLength2;
	/**
	 * 
	 */
	private String topJzgNo;
	/**
	 * 
	 */
	private String topJzgLife;
	/**
	 * 
	 */
	private String botJzgNo;
	/**
	 * 
	 */
	private String botJzgLife;
	/**
	 * 
	 */
	@JsonFormat(pattern = "HH:mm",timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date tm;

}
