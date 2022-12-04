package com.sinby.iadmin4J.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sinby.iadmin4J.dao.MdRhResultDao;
import com.sinby.iadmin4J.entity.MdRhResultEntity;
import com.sinby.iadmin4J.service.MdRhResultService;
import org.springframework.stereotype.Service;


@Service("mdRhResultService")
public class MdRhResultServiceImpl extends ServiceImpl<MdRhResultDao, MdRhResultEntity> implements MdRhResultService {

}