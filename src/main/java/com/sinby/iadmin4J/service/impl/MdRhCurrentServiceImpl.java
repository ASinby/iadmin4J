package com.sinby.iadmin4J.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sinby.iadmin4J.dao.MdRhCurrentDao;
import com.sinby.iadmin4J.entity.MdRhCurrentEntity;
import com.sinby.iadmin4J.service.MdRhCurrentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("mdRhCurrentService")
public class MdRhCurrentServiceImpl extends ServiceImpl<MdRhCurrentDao, MdRhCurrentEntity> implements MdRhCurrentService {

    @Autowired
    MdRhCurrentDao mdRhCurrentDao;

    @Override
    public boolean updateById(MdRhCurrentEntity entity) {
        return mdRhCurrentDao.updateBySV(entity);
    }
}