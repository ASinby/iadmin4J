package com.sinby.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sinby.demo.pojo.CraneStatus;
import com.sinby.demo.pojo.CraneTimeCensus;

import java.util.List;
import java.util.Map;

/**
 * @author ：sinby
 * @Date :2022/09/15 10:44
 * @Version 1.0
 */
public interface CraneTimeCensusService extends IService<CraneTimeCensus> {

    List<Map<String,Object>> getArriveLeaveTime(Map<String,Object> param);
}
