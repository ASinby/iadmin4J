package com.sinby.iadmin4J.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * 料仓信息
 * 
 * @author sinby
 * @date 2022-12-04 12:11:25
 */
@Data
@TableName("MD_BUNKER_INFO")
public class MdBunkerInfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private String bunkerNo;
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
	private Integer matSetw;
	/**
	 * 
	 */
	private Integer ifok;
	/**
	 * 
	 */
	@JsonFormat(pattern = "HH:mm",timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date tm;
	/**
	 * 
	 */
	private String treatNo;
	/**
	 * 
	 */
	private Integer matCalw;

}
