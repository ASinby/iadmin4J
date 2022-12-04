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
 * @date 2022-12-04 12:11:26
 */
@Data
@TableName("MD_ANA_STEEL")
public class MdAnaSteelEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
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
	private String plno;
	/**
	 * 
	 */
	private String treatNo;
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
	private String coVal;
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
	private String nVal;
	/**
	 * 
	 */
	private String bak1;
	/**
	 * 
	 */
	private String bak2;
	/**
	 * 
	 */
	private String bak3;
	/**
	 * 
	 */
	private String bak4;
	/**
	 * 
	 */
	private String bak5;
	/**
	 * 
	 */
	private String bak6;
	/**
	 * 
	 */
	private String bak7;
	/**
	 * 
	 */
	private String bak8;
	/**
	 * 
	 */
	private String bak9;
	/**
	 * 
	 */
	private String bak10;
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
