package com.sinby.iadmin4J.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sinby.iadmin4J.dao.MdPlanChangeDao;
import com.sinby.iadmin4J.entity.MdPlanChangeEntity;
import com.sinby.iadmin4J.service.MdPlanChangeService;
import org.springframework.stereotype.Service;


@Service("mdPlanChangeService")
public class MdPlanChangeServiceImpl extends ServiceImpl<MdPlanChangeDao, MdPlanChangeEntity> implements MdPlanChangeService {

}