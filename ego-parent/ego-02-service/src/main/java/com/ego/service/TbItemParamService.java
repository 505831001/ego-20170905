package com.ego.service;

import com.ego.entity.EasyResult;
import com.ego.entity.EasyUIPageVO;
import com.ego.entity.TbItemParam;

import java.util.List;

/**
 * <p>
 * 商品规则参数 服务类
 * </p>
 *
 * @author liuweiwei
 * @since 2020-05-19
 */
public interface TbItemParamService {
    public List<TbItemParam> query();

    public EasyUIPageVO list(int pageNum, int pageSize);

    EasyResult save(TbItemParam record);

    public int deleteBatch(Long[] ids);
}
