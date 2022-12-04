package com.sinby.iadmin4J.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sinby.iadmin4J.dao.MdOutTempDao;
import com.sinby.iadmin4J.entity.MdOutTempEntity;
import com.sinby.iadmin4J.service.MdOutTempService;
import org.springframework.stereotype.Service;


@Service("mdOutTempService")
public class MdOutTempServiceImpl extends ServiceImpl<MdOutTempDao, MdOutTempEntity> implements MdOutTempService {

}