package com.sinby.iadmin4J.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sinby.iadmin4J.dao.MdAlloySetDao;
import com.sinby.iadmin4J.entity.MdAlloySetEntity;
import com.sinby.iadmin4J.service.MdAlloySetService;
import org.springframework.stereotype.Service;


@Service("mdAlloySetService")
public class MdAlloySetServiceImpl extends ServiceImpl<MdAlloySetDao, MdAlloySetEntity> implements MdAlloySetService {

}