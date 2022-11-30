package com.sinby.demo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sinby.demo.pojo.CraneTimeCensus;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author ：sinby
 * @Date :2022/03/24 10:15
 * @Version 1.0
 */
@Mapper
@Repository
public interface CraneTimeCensusDao extends BaseMapper<CraneTimeCensus> {

    List<Map<String,Object>> getArriveLeaveTime(Map<String,Object> param);
}
