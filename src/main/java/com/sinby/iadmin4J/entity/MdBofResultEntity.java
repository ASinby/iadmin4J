package com.sinby.iadmin4J.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * 转炉实绩
 * 
 * @author sinby
 * @date 2022-12-04 12:11:26
 */
@Data
@TableName("MD_BOF_RESULT")
public class MdBofResultEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private String plno;
	/**
	 * 
	 */
	private String htno;
	/**
	 * 
	 */
	private String pono;
	/**
	 * 
	 */
	private String steelgrade;
	/**
	 * 
	 */
	private String bofno;
	/**
	 * 
	 */
	private String ldno;
	/**
	 * 
	 */
	private String tapsteelweight;
	/**
	 * 
	 */
	private String blowstarttime;
	/**
	 * 
	 */
	private String tappingendtime;
	/**
	 * 
	 */
	private String tapsteeltempMax;
	/**
	 * 
	 */
	private String tapsteeltempMin;
	/**
	 * 
	 */
	private String tapsteeltemp;
	/**
	 * 
	 */
	private String tapsteeltemptime;
	/**
	 * 
	 */
	private String blowstopo;
	/**
	 * 
	 */
	private String blownum;
	/**
	 * 
	 */
	private String tappingstarttime;
	/**
	 * 
	 */
	private String slagweight;
	/**
	 * 
	 */
	private String ladlestate;
	/**
	 * 
	 */
	private String ladlelevel;
	/**
	 * 
	 */
	private String blowo2time;
	/**
	 * 
	 */
	private String blowo2volume;
	/**
	 * 
	 */
	@JsonFormat(pattern = "HH:mm",timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date tm;

}
