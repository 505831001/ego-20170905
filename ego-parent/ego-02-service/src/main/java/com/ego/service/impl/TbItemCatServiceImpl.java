package com.ego.service.impl;

import com.ego.entity.TbItemCat;
import com.ego.mapper.TbItemCatMapper;
import com.ego.service.TbItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

/**
 * <p>
 * 商品类目 服务实现类
 * </p>
 *
 * @author liuweiwei
 * @since 2020-05-19
 */
@Service
public class TbItemCatServiceImpl implements TbItemCatService {

    @Autowired
    private TbItemCatMapper tbItemCatMapper;

    @Override
    public List<TbItemCat> list() {
        List<TbItemCat> list = tbItemCatMapper.selectAll();
        return list;
    }
}
