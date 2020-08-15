package com.ego.service;

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
    public EasyUIPageVO list(int pageNum, int pageSize);
}
