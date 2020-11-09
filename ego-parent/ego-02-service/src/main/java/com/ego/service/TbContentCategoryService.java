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

    // 新增功能
    int insert(TbContentCategory record);

    // 删除功能
    int delete(TbContentCategory example);

    // 修改功能
    int update(TbContentCategory record);

    // 根据父 id 查询所有子类目
    List<TbContentCategory> getByPrimaryKey(long id);

    //
    List<EasyUITree> list(Long id);
}
