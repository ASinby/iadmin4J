package com.sinby.iadmin4J.dao;

import com.sinby.iadmin4J.entity.MdAlloySetEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 钢水成分
 * 
 * @author sinby
 * @date 2022-12-04 12:11:25
 */
@Mapper
public interface MdAlloySetDao extends BaseMapper<MdAlloySetEntity> {
	public boolean updateByPFV(MdAlloySetEntity mdAlloySetEntity);
}
