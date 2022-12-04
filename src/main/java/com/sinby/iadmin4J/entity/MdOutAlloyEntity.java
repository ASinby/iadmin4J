package com.sinby.iadmin4J.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * 模型合金辅料输出表
 * 
 * @author sinby
 * @date 2022-12-04 12:11:25
 */
@Data
@TableName("MD_OUT_ALLOY")
public class MdOutAlloyEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private String treatNo;
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
	private Integer calw;
	/**
	 * 
	 */
	@JsonFormat(pattern = "HH:mm",timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date tm;
	/**
	 * 
	 */
	private String bunkerNo;

}
