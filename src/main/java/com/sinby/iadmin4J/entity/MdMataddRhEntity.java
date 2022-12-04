package com.sinby.iadmin4J.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * RH投料实绩
 * 
 * @author sinby
 * @date 2022-12-04 12:11:25
 */
@Data
@TableName("MD_MATADD_RH")
public class MdMataddRhEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private String stationNo;
	/**
	 * 
	 */
	private String prodTime;
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
	private String treatNo;
	/**
	 * 
	 */
	private String htno;
	/**
	 * 
	 */
	private String shiftNo;
	/**
	 * 
	 */
	private String groupNo;
	/**
	 * 
	 */
	private String matCode;
	/**
	 * 
	 */
	private String matName;
	/**
	 * 
	 */
	private String matAmount;
	/**
	 * 
	 */
	private String manualFlag;
	/**
	 * 
	 */
	private String matType;
	/**
	 * 
	 */
	@JsonFormat(pattern = "HH:mm",timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date tm;
	/**
	 * 
	 */
	private String stno;

}
