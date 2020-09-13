package com.ego.service.impl;

import com.ego.entity.EasyResult;
import com.ego.entity.EasyUIPageVO;
import com.ego.entity.TbItemParam;
import com.ego.mapper.TbItemCatMapper;
import com.ego.mapper.TbItemParamMapper;
import com.ego.service.TbItemParamService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * 商品规则参数 服务实现类
 * </p>
 *
 * @author liuweiwei
 * @since 2020-05-19
 */
@Service
public class TbItemParamServiceImpl implements TbItemParamService {
    /**
     * SLF4J 骚粉日志必备技能
     */
    protected static final Logger LOGGER = LoggerFactory.getLogger(TbItemServiceImpl.class);

    @Autowired
    protected TbItemParamMapper tbItemParamMapper;

    @Override
    public List<TbItemParam> query() {
        List<TbItemParam> data = tbItemParamMapper.selectAll();
        LOGGER.info("Database query data -> data: {}", data);
        return data;
    }

    /**
     * 分页查询商品参数集
     *
     * @param pageNum
     * @param pageSize
     * @return EasyUIPageVO
     */
    @Override
    public EasyUIPageVO list(int pageNum, int pageSize) {
        /**
         * 分页返回类
         */
        EasyUIPageVO easyUIPageVO = new EasyUIPageVO();
        int startPage = (pageNum - 1) * pageSize;
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

        LOGGER.info("Database query data -> rows: {}, count: {}", rows, count);
        return easyUIPageVO;
    }

    /**
     * 保存商品参数信息
     *
     * @param record
     * @return EasyResult
     */
    @Override
    public EasyResult save(TbItemParam record) {
        EasyResult result = new EasyResult();
        int insert = tbItemParamMapper.insert(record);
        result.setData(insert);
        return result;
    }

    /**
     * 批量删除商品参数
     *
     * @param ids
     * @return int
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteBatch(Long[] ids) {
        int index = 0;

        // 1. 字符集方式
        /*
        String[] strings = ids.split(",");
        for (String id : strings) {
            index += tbItemParamMapper.deleteByPrimaryKey(Long.parseLong(id));
        }

        // 2. List<Long> 集合方式
        for (Long id: ids) {
            index += tbItemParamMapper.deleteByPrimaryKey(id);
        }
        */

        // 3. Long[] 数组方式
        for (int i = 0; i < ids.length; i++) {
            index += tbItemParamMapper.deleteByPrimaryKey(ids[i]);
        }

        index = tbItemParamMapper.deleteBatch(ids);
        return index;
    }
}
