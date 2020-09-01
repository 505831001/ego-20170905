package com.ego.service.impl;

import com.ego.entity.EasyUIPageVO;
import com.ego.entity.TbItemParam;
import com.ego.entity.TbItemParamPlus;
import com.ego.mapper.TbItemCatMapper;
import com.ego.mapper.TbItemParamMapper;
import com.ego.service.TbItemParamService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.LinkedList;
import java.util.List;

/**
 * <p>
 * 商品规则参数 服务实现类
 * </p>
 *
 * @author liuweiwei
 * @since 2020-05-19
 */
@Component
public class TbItemParamServiceImpl implements TbItemParamService {
    /**
     * SLF4J 狂人必备日志技能
     */
    protected static final Logger LOGGER = LoggerFactory.getLogger(TbItemServiceImpl.class);

    @Autowired
    protected TbItemParamMapper tbItemParamMapper;

    @Autowired
    protected TbItemCatMapper tbItemCatMapper;

    protected EasyUIPageVO easyUIPageVO;

    @Override
    public List<TbItemParam> query() {
        List<TbItemParam> data = tbItemParamMapper.selectAll();
        return data;
    }

    @Override
    public EasyUIPageVO list(int pageNum, int pageSize) {
        EasyUIPageVO easyUIPageVO = new EasyUIPageVO();
        int startPage = (pageNum -1) * pageSize;
        /**
         * 数据集
         */
        List<TbItemParam> rows = tbItemParamMapper.selectItemPageList(startPage, pageSize);
        easyUIPageVO.setRows(rows);
        /**
         * 总条数
         */
        long count = tbItemParamMapper.count();
        easyUIPageVO.setTotal(Integer.parseInt(String.valueOf(count)));
        return easyUIPageVO;
    }
}
