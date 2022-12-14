package com.sinby.iadmin4J.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sinby.iadmin4J.entity.MdBunkerInfoEntity;

import java.util.Map;

/**
 * 料仓信息
 *
 * @author sinby
 * @date 2022-12-04 12:11:25
 */
public interface MdBunkerInfoService extends IService<MdBunkerInfoEntity> {
    public boolean updateByBT(Map<String,Object> param);
}

