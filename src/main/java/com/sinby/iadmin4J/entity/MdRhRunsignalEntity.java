package com.sinby.iadmin4J.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * RH运转状况
 * 
 * @author sinby
 * @date 2022-12-04 12:11:25
 */
@Data
@TableName("MD_RH_RUNSIGNAL")
public class MdRhRunsignalEntity implements Serializable {
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
	private String htno;
	/**
	 * 
	 */
	private String treatNo;
	/**
	 * 
	 */
	private String stno;
	/**
	 * 
	 */
	private String statusCode;
	/**
	 * 
	 */
	private String statusTime;
	/**
	 * 
	 */
	private String devCode;
	/**
	 * 
	 */
	private String stationNo;
	/**
	 * 
	 */
	private String treatmentCounter;
	/**
	 * 
	 */
	@JsonFormat(pattern = "HH:mm",timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date tm;

}
