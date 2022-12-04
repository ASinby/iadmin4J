package com.sinby.iadmin4J.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sinby.iadmin4J.pojo.MdAlloySet;
import com.sinby.iadmin4J.pojo.MdRhCurrent;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author：sinby
 * @Date: 2022/12/3 14:34
 * @Description: XXX
 */
@Mapper
@Repository
public interface AlloySetDao extends BaseMapper<MdAlloySet> {
}
