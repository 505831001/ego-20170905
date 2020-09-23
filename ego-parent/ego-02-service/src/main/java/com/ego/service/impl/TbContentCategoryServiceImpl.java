package com.ego.service.impl;

import com.ego.entity.EasyUITree;
import com.ego.entity.TbContentCategory;
import com.ego.mapper.TbContentCategoryMapper;
import com.ego.service.TbContentCategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
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
    public List<EasyUITree> list(Long id) {
        List<EasyUITree> list = new LinkedList<>();
        List<TbContentCategory> data = tbContentCategoryMapper.selectAll(0L);
        for (TbContentCategory po : data) {
            EasyUITree uiTree = new EasyUITree();
            // BeanUtils.copyProperties(po, uiTree);
            uiTree.setId(po.getId());
            uiTree.setText(po.getName());
            uiTree.setState(po.getIsParent() ? "closed" : "open");
            list.add(uiTree);
        }
        return list;
    }
}
