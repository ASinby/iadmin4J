package com.sinby.iadmin4J.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sinby.iadmin4J.dao.MdBunkerInfoDao;
import com.sinby.iadmin4J.entity.MdBunkerInfoEntity;
import com.sinby.iadmin4J.service.MdBunkerInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("mdBunkerInfoService")
public class MdBunkerInfoServiceImpl extends ServiceImpl<MdBunkerInfoDao, MdBunkerInfoEntity> implements MdBunkerInfoService {

    @Autowired
    MdBunkerInfoDao mdBunkerInfoDao;
    @Override
    public boolean updateByBT(Map<String, Object> param) {
        return mdBunkerInfoDao.updateCalcResultByBT(param);
    }
}