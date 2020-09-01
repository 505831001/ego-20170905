package com.ego.service.impl;

import com.ego.entity.TbItem;
import com.ego.entity.TbItemDesc;
import com.ego.mapper.TbItemMapper;
import com.ego.service.TbItemService;
import com.ego.utils.IDUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * <p>
 * 商品表 服务实现类
 * </p>
 *
 * @author liuweiwei
 * @since 2020-05-19
 */
@Service
public class TbItemServiceImpl implements TbItemService {
    /**
     * SLF4J 狂人必备日志技能
     */
    protected static final Logger LOGGER = LoggerFactory.getLogger(TbItemServiceImpl.class);

    @Autowired
    protected TbItemMapper tbItemMapper;

    /**
     * 分页查询物料列表
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public List<TbItem> list(int pageNum, int pageSize) {
        List<TbItem> itemPageList = tbItemMapper.selectItemPageList(pageNum, pageSize);
        return itemPageList;
    }

    /**
     * 分页查询物料信息
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public PageInfo<TbItem> query(int pageNum, int pageSize) {
        // 1. 设置分页条件
        PageHelper.startPage(pageNum, pageSize);
        // 2. 分页封装
        PageInfo<TbItem> pageInfo = new PageInfo<>();
        pageInfo.setPageNum(pageNum);
        pageInfo.setPageSize(pageSize);
        pageInfo.setTotal(tbItemMapper.count());
        pageInfo.setList(tbItemMapper.selectItemPageList(pageNum, pageSize));
        // 3. 返回分页结果集
        return pageInfo;
    }

    /**
     * 上架物料
     *
     * @param ids
     * @return
     */
    @Override
    public Integer reshelf(String ids) throws Exception {
        List<Integer> list = new LinkedList<>();
        int index = 0;
        String[] idArray = ids.split(",");
        for (String id : idArray) {
            index += tbItemMapper.reshelf(Long.parseLong(id));
            list.add(index);
        }
        return index;
    }

    /**
     * 下架物料
     *
     * @param ids
     * @return
     */
    @Override
    public Integer instock(String ids) throws Exception {
        String[] idArray = ids.split(",");
        int index = 0;
        for (String id : idArray) {
            TbItem item = tbItemMapper.selectByPrimaryKey(Long.parseLong(id));
            System.out.println("Before querying the database -> " + item.getStatus());
            item.setId(Long.parseLong(id));
            index += tbItemMapper.instock(item);
            item = tbItemMapper.selectByPrimaryKey(Long.parseLong(id));
            System.out.println("After querying the database -> " + item.getStatus());
        }
        return index;
    }

    /**
     * 删除物料
     *
     * @param ids
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer delete(String ids) throws Exception {
        String[] idArray = ids.split(",");
        int index = 0;
        for (String id : idArray) {
            TbItem item = tbItemMapper.selectByPrimaryKey(Long.parseLong(id));
            item.setId(Long.parseLong(id));
            index += tbItemMapper.delete(item);
        }
        LOGGER.info("The total number of batch deletions is -> index: {}" + index);
        return index;
    }

    /**
     * 新增物料
     *
     * @param tbItem
     * @param desc
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer save(TbItem tbItem, String desc) throws Exception {
        int index = 0;
        long id = IDUtils.genItemId();

        TbItemDesc itemDesc = new TbItemDesc();
        itemDesc.setItemDesc(desc);
        itemDesc.setItemId(id);
        itemDesc.setCreated(new Date());
        itemDesc.setUpdated(new Date());

        tbItem.setCreated(new Date());
        tbItem.setUpdated(new Date());
        tbItem.setStatus(Byte.parseByte("1"));
        index += tbItemMapper.insert(tbItem);
        return index;
    }
}
