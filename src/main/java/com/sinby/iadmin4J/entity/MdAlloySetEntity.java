package com.sinby.iadmin4J.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * 钢水成分
 * 
 * @author sinby
 * @date 2022-12-04 12:11:25
 */
@Data
@TableName("MD_ALLOY_SET")
public class MdAlloySetEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private String flag;
	/**
	 * 
	 */
	private String plno;
	/**
	 * 
	 */
	private String stno;
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
	private String sampleNo;
	/**
	 * 
	 */
	private String htno;
	/**
	 * 
	 */
	private String anaTm;
	/**
	 * 
	 */
	private String cVal;
	/**
	 * 
	 */
	private String siVal;
	/**
	 * 
	 */
	private String mnVal;
	/**
	 * 
	 */
	private String pVal;
	/**
	 * 
	 */
	private String sVal;
	/**
	 * 
	 */
	private String mgVal;
	/**
	 * 
	 */
	private String crVal;
	/**
	 * 
	 */
	private String niVal;
	/**
	 * 
	 */
	private String moVal;
	/**
	 * 
	 */
	private String cuVal;
	/**
	 * 
	 */
	private String alVal;
	/**
	 * 
	 */
	private String tiVal;
	/**
	 * 
	 */
	private String vVal;
	/**
	 * 
	 */
	private String nbVal;
	/**
	 * 
	 */
	private String wVal;
	/**
	 * 
	 */
	private String bVal;
	/**
	 * 
	 */
	private String caVal;
	/**
	 * 
	 */
	private String sbVal;
	/**
	 * 
	 */
	private String asVal;
	/**
	 * 
	 */
	private String snVal;
	/**
	 * 
	 */
	private String pbVal;
	/**
	 * 
	 */
	private String biVal;
	/**
	 * 
	 */
	private String ceVal;
	/**
	 * 
	 */
	private String coVal;
	/**
	 * 
	 */
	private String nVal;
	/**
	 * 
	 */
	@JsonFormat(pattern = "HH:mm",timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date tm;
	/**
	 * 记录版本号，单调增。防止前端修改时出现“不可重复读”。每一新炉次开始，采集数据程序需将其置为0。默认为0
	 */
	private Integer version1;
}
