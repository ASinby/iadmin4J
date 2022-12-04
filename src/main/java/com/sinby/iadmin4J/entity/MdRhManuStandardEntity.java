package com.sinby.iadmin4J.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * RH制造标准
 * 
 * @author sinby
 * @date 2022-12-04 12:11:25
 */
@Data
@TableName("MD_RH_MANU_STANDARD")
public class MdRhManuStandardEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private String stno;
	/**
	 * 
	 */
	private String factoryDiv;
	/**
	 * 
	 */
	private String routeIdCode;
	/**
	 * 
	 */
	private String rhSgGroup;
	/**
	 * 
	 */
	private String steelGroup;
	/**
	 * 
	 */
	private String steelGroupDesc;
	/**
	 * 
	 */
	private String slagThickLadle;
	/**
	 * 
	 */
	private String rhType;
	/**
	 * 
	 */
	private String rhDeci;
	/**
	 * 
	 */
	private String rhDoDeci;
	/**
	 * 
	 */
	private String oxpAim;
	/**
	 * 
	 */
	private String rhDcDeci;
	/**
	 * 
	 */
	private String deOxpDecide;
	/**
	 * 
	 */
	private String deDecide;
	/**
	 * 
	 */
	private String cirGasDeci;
	/**
	 * 
	 */
	private String dealTimeDeci;
	/**
	 * 
	 */
	private String dealGasTimeDeci;
	/**
	 * 
	 */
	private String rhSpeAlloy;
	/**
	 * 
	 */
	private String rhTempMin;
	/**
	 * 
	 */
	private String rhTempMax;
	/**
	 * 
	 */
	private String rhTempAim;
	/**
	 * 
	 */
	private String lineDecide;
	/**
	 * 
	 */
	private String fdLnSpeed;
	/**
	 * 
	 */
	private String silkComsume;
	/**
	 * 
	 */
	private String rhWsTempL;
	/**
	 * 
	 */
	private String rhWsTempU;
	/**
	 * 
	 */
	private String rhWsTempA;
	/**
	 * 
	 */
	private String tempPreserve;
	/**
	 * 
	 */
	private String deSulfurFlag;
	/**
	 * 
	 */
	private String specialRemark;
	/**
	 * 
	 */
	private String vacuumDegreeAim;
	/**
	 * 
	 */
	private String tempPreserveDir;
	/**
	 * 
	 */
	private String killTimeAim;
	/**
	 * 
	 */
	private String killTimeMax;
	/**
	 * 
	 */
	private String killTimeMin;
	/**
	 * 
	 */
	private String mtrlName1;
	/**
	 * 
	 */
	private String mtrlValue1;
	/**
	 * 
	 */
	private String mtrlName2;
	/**
	 * 
	 */
	private String mtrlValue2;
	/**
	 * 
	 */
	private String mtrlName3;
	/**
	 * 
	 */
	private String mtrlValue3;
	/**
	 * 
	 */
	private String mtrlName4;
	/**
	 * 
	 */
	private String mtrlValue4;
	/**
	 * 
	 */
	private String mtrlName5;
	/**
	 * 
	 */
	private String mtrlValue5;
	/**
	 * 
	 */
	private String mtrlName6;
	/**
	 * 
	 */
	private String mtrlValue6;
	/**
	 * 
	 */
	private String mtrlName7;
	/**
	 * 
	 */
	private String mtrlValue7;
	/**
	 * 
	 */
	private String mtrlName8;
	/**
	 * 
	 */
	private String mtrlValue8;
	/**
	 * 
	 */
	private String rhNogasPattern;
	/**
	 * 
	 */
	private String rhO2Pattern;
	/**
	 * 
	 */
	private String rhOptionPattern;
	/**
	 * 
	 */
	private String cirGasPattern;
	/**
	 * 
	 */
	private String stageReserv1;
	/**
	 * 
	 */
	private String stageReserv2;
	/**
	 * 
	 */
	private String rhSteelSample;
	/**
	 * 
	 */
	private String rhSteelAlsSample;
	/**
	 * 
	 */
	private String rhOnSample;
	/**
	 * 
	 */
	private String rhHSample;
	/**
	 * 
	 */
	private String rhSlagSample;
	/**
	 * 
	 */
	private String procAim;
	/**
	 * 
	 */
	private String ptnNo;
	/**
	 * 
	 */
	private String freeoNorm;
	/**
	 * 
	 */
	private String freeoCNorm;
	/**
	 * 
	 */
	private String freeoAlNorm;
	/**
	 * 
	 */
	private String alTempNorm;
	/**
	 * 
	 */
	private String dippNorm;
	/**
	 * 
	 */
	private String alloyRatioStudyGroup;
	/**
	 * 
	 */
	private String tempNorm;
	/**
	 * 
	 */
	private String airflowType;
	/**
	 * 
	 */
	private String rhKtbPtn;
	/**
	 * 
	 */
	private String rhKtbPtnAid;
	/**
	 * 
	 */
	private String silkMixFlow;
	/**
	 * 
	 */
	private String silkMixTime;
	/**
	 * 
	 */
	private String slagOffNorm;
	/**
	 * 
	 */
	private String tempSteelMax;
	/**
	 * 
	 */
	private String tempSteelMin;
	/**
	 * 
	 */
	private String tempAim;
	/**
	 * 
	 */
	private String tempMax;
	/**
	 * 
	 */
	private String tempMin;
	/**
	 * 
	 */
	private String tempEnd;
	/**
	 * 
	 */
	private String tempEndMax;
	/**
	 * 
	 */
	private String tempEndMin;
	/**
	 * 
	 */
	private String rhTimeMax;
	/**
	 * 
	 */
	private String rhTimeMin;
	/**
	 * 
	 */
	private String timeMax;
	/**
	 * 
	 */
	private String timeMin;
	/**
	 * 
	 */
	private String oxp;
	/**
	 * 
	 */
	private String oxpMax;
	/**
	 * 
	 */
	private String oxpMin;
	/**
	 * 
	 */
	private String feedDiv;
	/**
	 * 
	 */
	private String feedDiv1;
	/**
	 * 
	 */
	private String warmMatrl;
	/**
	 * 
	 */
	private String coolMatrl;
	/**
	 * 
	 */
	private String addCDeci;
	/**
	 * 
	 */
	private String alloyCon;
	/**
	 * 
	 */
	private String alCon;
	/**
	 * 
	 */
	private String cPowderCon;
	/**
	 * 
	 */
	private String coolCon;
	/**
	 * 
	 */
	private String feedCon;
	/**
	 * 
	 */
	private String oCon;
	/**
	 * 
	 */
	private String alloyRatioCon;
	/**
	 * 
	 */
	private String o2Req;
	/**
	 * 
	 */
	private String n2Req;
	/**
	 * 
	 */
	private String arReq;
	/**
	 * 
	 */
	private String cAim;
	/**
	 * 
	 */
	private String cMax;
	/**
	 * 
	 */
	private String cMin;
	/**
	 * 
	 */
	private String siAim;
	/**
	 * 
	 */
	private String siMax;
	/**
	 * 
	 */
	private String siMin;
	/**
	 * 
	 */
	private String mnAim;
	/**
	 * 
	 */
	private String mnMax;
	/**
	 * 
	 */
	private String mnMin;
	/**
	 * 
	 */
	private String sAim;
	/**
	 * 
	 */
	private String sMax;
	/**
	 * 
	 */
	private String sMin;
	/**
	 * 
	 */
	private String pAim;
	/**
	 * 
	 */
	private String pMax;
	/**
	 * 
	 */
	private String pMin;
	/**
	 * 
	 */
	private String crAim;
	/**
	 * 
	 */
	private String crMax;
	/**
	 * 
	 */
	private String crMin;
	/**
	 * 
	 */
	private String niAim;
	/**
	 * 
	 */
	private String niMax;
	/**
	 * 
	 */
	private String niMin;
	/**
	 * 
	 */
	private String cuAim;
	/**
	 * 
	 */
	private String cuMax;
	/**
	 * 
	 */
	private String cuMin;
	/**
	 * 
	 */
	private String moAim;
	/**
	 * 
	 */
	private String moMax;
	/**
	 * 
	 */
	private String moMin;
	/**
	 * 
	 */
	private String vAim;
	/**
	 * 
	 */
	private String vMax;
	/**
	 * 
	 */
	private String vMin;
	/**
	 * 
	 */
	private String asAim;
	/**
	 * 
	 */
	private String asMax;
	/**
	 * 
	 */
	private String asMin;
	/**
	 * 
	 */
	private String snAim;
	/**
	 * 
	 */
	private String snMax;
	/**
	 * 
	 */
	private String snMin;
	/**
	 * 
	 */
	private String alAim;
	/**
	 * 
	 */
	private String alMax;
	/**
	 * 
	 */
	private String alMin;
	/**
	 * 
	 */
	private String tiAim;
	/**
	 * 
	 */
	private String tiMax;
	/**
	 * 
	 */
	private String tiMin;
	/**
	 * 
	 */
	private String nbAim;
	/**
	 * 
	 */
	private String nbMax;
	/**
	 * 
	 */
	private String nbMin;
	/**
	 * 
	 */
	private String bAim;
	/**
	 * 
	 */
	private String bMax;
	/**
	 * 
	 */
	private String bMin;
	/**
	 * 
	 */
	private String zrAim;
	/**
	 * 
	 */
	private String zrMax;
	/**
	 * 
	 */
	private String zrMin;
	/**
	 * 
	 */
	private String znAim;
	/**
	 * 
	 */
	private String znMax;
	/**
	 * 
	 */
	private String znMin;
	/**
	 * 
	 */
	private String pbAim;
	/**
	 * 
	 */
	private String pbMax;
	/**
	 * 
	 */
	private String pbMin;
	/**
	 * 
	 */
	private String coAim;
	/**
	 * 
	 */
	private String coMax;
	/**
	 * 
	 */
	private String coMin;
	/**
	 * 
	 */
	private String caAim;
	/**
	 * 
	 */
	private String caMax;
	/**
	 * 
	 */
	private String caMin;
	/**
	 * 
	 */
	private String sbAim;
	/**
	 * 
	 */
	private String sbMax;
	/**
	 * 
	 */
	private String sbMin;
	/**
	 * 
	 */
	private String reAim;
	/**
	 * 
	 */
	private String reMax;
	/**
	 * 
	 */
	private String reMin;
	/**
	 * 
	 */
	private String solAlAim;
	/**
	 * 
	 */
	private String solAlMax;
	/**
	 * 
	 */
	private String solAlMin;
	/**
	 * 
	 */
	private String wAim;
	/**
	 * 
	 */
	private String wMax;
	/**
	 * 
	 */
	private String wMin;
	/**
	 * 
	 */
	private String oAim;
	/**
	 * 
	 */
	private String oMax;
	/**
	 * 
	 */
	private String oMin;
	/**
	 * 
	 */
	private String nAim;
	/**
	 * 
	 */
	private String nMax;
	/**
	 * 
	 */
	private String nMin;
	/**
	 * 
	 */
	private String hAim;
	/**
	 * 
	 */
	private String hMax;
	/**
	 * 
	 */
	private String hMin;
	/**
	 * 
	 */
	private String yb1Name;
	/**
	 * 
	 */
	private String yb1Aim;
	/**
	 * 
	 */
	private String yb1Max;
	/**
	 * 
	 */
	private String yb1Min;
	/**
	 * 
	 */
	private String yb2Name;
	/**
	 * 
	 */
	private String yb2Aim;
	/**
	 * 
	 */
	private String yb2Max;
	/**
	 * 
	 */
	private String yb2Min;
	/**
	 * 
	 */
	private String mtrlName13;
	/**
	 * 
	 */
	private String mtrlValue13;
	/**
	 * 
	 */
	private String mtrlName14;
	/**
	 * 
	 */
	private String mtrlValue14;
	/**
	 * 
	 */
	private String mtrlName15;
	/**
	 * 
	 */
	private String mtrlValue15;
	/**
	 * 
	 */
	private String steelSmpType2;
	/**
	 * 
	 */
	private String inTempAim;
	/**
	 * 
	 */
	private String imTempMax;
	/**
	 * 
	 */
	private String inTempMin;
	/**
	 * 
	 */
	@JsonFormat(pattern = "HH:mm",timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date tm;

}
