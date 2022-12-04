package com.sinby.iadmin4J.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * 物料信息
 * 
 * @author sinby
 * @date 2022-12-04 12:11:25
 */
@Data
@TableName("MD_MAT_INFO")
public class MdMatInfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private String matCode;
	/**
	 * 
	 */
	private String matNameE;
	/**
	 * 
	 */
	private String matNameC;
	/**
	 * 
	 */
	private String matType;
	/**
	 * 
	 */
	private String batchNo;
	/**
	 * 
	 */
	private String eleName;
	/**
	 * 
	 */
	private String eleRatio;
	/**
	 * 
	 */
	private String density;
	/**
	 * 
	 */
	private String bulkDensity;
	/**
	 * 
	 */
	private String silkWeight;
	/**
	 * 
	 */
	private String silkSpeed;
	/**
	 * 
	 */
	private String factor;
	/**
	 * 
	 */
	private String han;
	/**
	 * 
	 */
	private String price;
	/**
	 * 
	 */
	private String routeIdCode;
	/**
	 * 
	 */
	@JsonFormat(pattern = "HH:mm",timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date tm;
	/**
	 * 
	 */
	private String yield;

}
