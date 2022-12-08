package com.sinby.iadmin4J.dao;

import com.sinby.iadmin4J.entity.MdRhCurrentEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * RH当前最新状态
 * 
 * @author sinby
 * @date 2022-12-04 12:11:25
 */
@Mapper
public interface MdRhCurrentDao extends BaseMapper<MdRhCurrentEntity> {
	public boolean updateBySV(MdRhCurrentEntity mdRhCurrentEntity);
}
