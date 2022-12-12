package com.sinby.iadmin4J.dao;

import com.sinby.iadmin4J.entity.MdBunkerInfoEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

/**
 * 料仓信息
 * 
 * @author sinby
 * @date 2022-12-04 12:11:25
 */
@Mapper
public interface MdBunkerInfoDao extends BaseMapper<MdBunkerInfoEntity> {
    public boolean updateCalcResultByBT(Map<String,Object> param);
}
