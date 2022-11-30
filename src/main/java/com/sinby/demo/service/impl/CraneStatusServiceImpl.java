package com.sinby.demo.service.impl;

import com.sinby.demo.dao.CraneStatusDao;
import com.sinby.demo.pojo.CraneStatus;
import com.sinby.demo.pojo.CraneTimeCensus;
import com.sinby.demo.service.CraneStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author：sinby
 * @Date: 2022/09/15 14:45
 * @Description: XXXX
 */

@Service
public class CraneStatusServiceImpl implements CraneStatusService {

    @Autowired
    CraneStatusDao craneStatusDao = null;

    @Override
    public List<CraneStatus> getCraneNowData(Map<String, Object> param) {
        return craneStatusDao.getCraneNowData(param);
    }

    @Override
    public void calculateWorkTm() {
        craneStatusDao.calculateWorkTm();
    }

    @Override
    public Map<String, Map<String,Object>> getMinTmForInsert() {
        return craneStatusDao.getMinTmForInsert();
    }

    @Override
    public List<Map<String, Object>> checkExistOfMinTm(Map<String, Object> param) {
        return craneStatusDao.checkExistOfMinTm(param);
    }

    @Override
    public void insertMinTm(Map<String, Object> param) {
        craneStatusDao.insertMinTm(param);
    }

    @Override
    public void updateMinTm(Map<String, Object> param) {
        craneStatusDao.updateMinTm(param);
    }

    @Override
    public List<CraneTimeCensus> getUpDownTimeForInsert() {
        return craneStatusDao.getUpDownTimeForInsert();
    }
}
