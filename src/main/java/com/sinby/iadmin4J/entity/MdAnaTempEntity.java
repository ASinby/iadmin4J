package com.sinby.iadmin4J.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * 测温信息
 * 
 * @author sinby
 * @date 2022-12-04 12:11:26
 */
@Data
@TableName("MD_ANA_TEMP")
public class MdAnaTempEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private String cwFlag;
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
	private String stno;
	/**
	 * 
	 */
	private String stnoDesc;
	/**
	 * 
	 */
	private String treatNo;
	/**
	 * 
	 */
	private String postCode;
	/**
	 * 
	 */
	private String tempTm;
	/**
	 * 
	 */
	private String temp;
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
	private String plno;
	/**
	 * 
	 */
	@JsonFormat(pattern = "HH:mm",timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date tm;

}
