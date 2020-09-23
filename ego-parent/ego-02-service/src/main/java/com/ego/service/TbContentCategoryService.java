package com.ego.service;

import com.ego.entity.EasyUITree;
import com.ego.entity.TbContentCategory;

import java.util.List;

/**
 * <p>
 * 内容分类 服务类
 * </p>
 *
 * @author liuweiwei
 * @since 2020-05-19
 */
public interface TbContentCategoryService {
    List<EasyUITree> list(Long id);
}
