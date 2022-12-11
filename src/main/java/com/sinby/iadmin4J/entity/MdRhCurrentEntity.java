package com.sinby.iadmin4J.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Date;

/**
 * RH当前最新状态
 * 
 * @author sinby
 * @date 2022-12-04 12:11:25
 */
@Data
@TableName("MD_RH_CURRENT")
public class MdRhCurrentEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	@NotEmpty(message = "工位号不可为空！")
	private String station1;
	/**
	 * 
	 */
	private String treatno;
	/**
	 * 
	 */
	private String stno;
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
	private String treatStartTm;
	/**
	 * 
	 */
	private String aimOxp;
	/**
	 * 
	 */
	private Integer setO2;
	/**
	 * 
	 */
	private String blowO2Mode;
	/**
	 * 
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date runTm;
	/**
	 * 
	 */
	private Integer forecastO2;
	/**
	 * 
	 */
	private Integer treatSpan;
	/**
	 * 
	 */
	private Integer killingC;
	/**
	 * 
	 */
	private String tips;
	/**
	 * 
	 */
	private String preC;
	/**
	 * 
	 */
	private String preOxp;
	/**
	 * 
	 */
	private String aimC;
	/**
	 * 
	 */
	private String steelTemp;
	/**
	 * 
	 */
	private String steelWeight;
	/**
	 * 
	 */
	private String stStatus;
	/**
	 * 
	 */
	private String treatEndTm;
	/**
	 * 
	 */
	private String vacTankTemp;
	/**
	 * 
	 */
	private String vacTankTempAdd;
	/**
	 * 
	 */
	private String vacTankAlAdd;
	/**
	 * 
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date tm;
	/**
	 * 
	 */
	private String alloyAddWeight;
	/**
	 * 
	 */
	private String alloyAllCost;
	/**
	 * 是否开始计算标志 0否  1是  默认0
	 */
	private String doCalcFlag;
	/**
	 * 记录版本号，防止出现“不可重复读”，单调增
	 */
	private Integer version1;
}
