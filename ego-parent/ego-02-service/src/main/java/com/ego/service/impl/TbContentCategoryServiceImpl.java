package com.ego.service.impl;

import com.ego.entity.TbContentCategory;
import com.ego.mapper.TbContentCategoryMapper;
import com.ego.service.TbContentCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 内容分类 服务实现类
 * </p>
 *
 * @author liuweiwei
 * @since 2020-05-19
 */
@Service
public class TbContentCategoryServiceImpl implements TbContentCategoryService {

    @Autowired
    private TbContentCategoryMapper tbContentCategoryMapper;

    @Override
    public List<TbContentCategory> list() {
        List<TbContentCategory> list = tbContentCategoryMapper.selectAll();
        return list;
    }
}
