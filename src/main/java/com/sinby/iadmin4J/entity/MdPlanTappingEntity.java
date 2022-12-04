package com.sinby.iadmin4J.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * 出钢计划
 * 
 * @author sinby
 * @date 2022-12-04 12:11:25
 */
@Data
@TableName("MD_PLAN_TAPPING")
public class MdPlanTappingEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private String plno;
	/**
	 * 
	 */
	private String pono;
	/**
	 * 
	 */
	private String castLotNo;
	/**
	 * 
	 */
	private String heatNo;
	/**
	 * 
	 */
	private String stno;
	/**
	 * 
	 */
	private String steelRouteCode;
	/**
	 * 
	 */
	private String backlogEa;
	/**
	 * 
	 */
	private String refineRouteCode;
	/**
	 * 
	 */
	private String bofNo;
	/**
	 * 
	 */
	private String aodFlag;
	/**
	 * 
	 */
	private String aodNo;
	/**
	 * 
	 */
	private String alloyNo;
	/**
	 * 
	 */
	private String ccMachNo;
	/**
	 * 
	 */
	private String castno;
	/**
	 * 
	 */
	private String castPonoSum;
	/**
	 * 
	 */
	private String castDivNo;
	/**
	 * 
	 */
	private String sPtn;
	/**
	 * 
	 */
	private String arNo;
	/**
	 * 
	 */
	private String tundishFlag;
	/**
	 * 
	 */
	private String dpDcRefer;
	/**
	 * 
	 */
	private String krStartTime;
	/**
	 * 
	 */
	private String bofBlowTime;
	/**
	 * 
	 */
	private String bofTabEndTime;
	/**
	 * 
	 */
	private String aodBlowTime;
	/**
	 * 
	 */
	private String aodTabEndTime;
	/**
	 * 
	 */
	private String refineStart1;
	/**
	 * 
	 */
	private String refineEnd1;
	/**
	 * 
	 */
	private String refineDesc1;
	/**
	 * 
	 */
	private String refineStart2;
	/**
	 * 
	 */
	private String refineEnd2;
	/**
	 * 
	 */
	private String refineDesc2;
	/**
	 * 
	 */
	private String refineStart3;
	/**
	 * 
	 */
	private String refineEnd3;
	/**
	 * 
	 */
	private String refineDesc3;
	/**
	 * 
	 */
	private String refineStart4;
	/**
	 * 
	 */
	private String refineEnd4;
	/**
	 * 
	 */
	private String refineDesc4;
	/**
	 * 
	 */
	private String ladleArriveTime;
	/**
	 * 
	 */
	private String ladleStartTime;
	/**
	 * 
	 */
	private String ladleEndTime;
	/**
	 * 
	 */
	private String planSteelWeigh;
	/**
	 * 
	 */
	private String section;
	/**
	 * 
	 */
	@JsonFormat(pattern = "HH:mm",timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date tm;

}
