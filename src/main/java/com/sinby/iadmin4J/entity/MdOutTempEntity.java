package com.sinby.iadmin4J.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 模型温度预测
 * 
 * @author sinby
 * @date 2022-12-04 12:11:25
 */
@Data
@TableName("MD_OUT_TEMP")
public class MdOutTempEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private String treatNo;
	/**
	 * 
	 */
	private String plno;
	/**
	 * 
	 */
	private Integer id;
	/**
	 * 
	 */
	private Integer tempPre;
	/**
	 * 
	 */
	private Integer tempAct;

}
