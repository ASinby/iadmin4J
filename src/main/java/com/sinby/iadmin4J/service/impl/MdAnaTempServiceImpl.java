package com.sinby.iadmin4J.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sinby.iadmin4J.dao.MdAnaTempDao;
import com.sinby.iadmin4J.entity.MdAnaTempEntity;
import com.sinby.iadmin4J.service.MdAnaTempService;
import org.springframework.stereotype.Service;


@Service("mdAnaTempService")
public class MdAnaTempServiceImpl extends ServiceImpl<MdAnaTempDao, MdAnaTempEntity> implements MdAnaTempService {

}