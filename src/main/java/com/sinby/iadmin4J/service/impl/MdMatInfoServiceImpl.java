package com.sinby.iadmin4J.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sinby.iadmin4J.dao.MdMatInfoDao;
import com.sinby.iadmin4J.entity.MdMatInfoEntity;
import com.sinby.iadmin4J.service.MdMatInfoService;
import org.springframework.stereotype.Service;


@Service("mdMatInfoService")
public class MdMatInfoServiceImpl extends ServiceImpl<MdMatInfoDao, MdMatInfoEntity> implements MdMatInfoService {

}