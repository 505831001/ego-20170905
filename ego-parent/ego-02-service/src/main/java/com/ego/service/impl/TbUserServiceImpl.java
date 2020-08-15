package com.ego.service.impl;

import com.ego.entity.TbUser;
import com.ego.mapper.TbUserMapper;
import com.ego.service.TbUserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author liuweiwei
 * @since 2020-05-19
 */
@Service
public class TbUserServiceImpl implements TbUserService {

    @Autowired
    private TbUserMapper tbUserMapper;

    @Override
    public List<TbUser> getAll() {
        return tbUserMapper.selectAll();
    }

    @Override
    public List<TbUser> query(int pageNum, int pageSize) {
        PageInfo<Object> pageInfo = new PageInfo<>();
        pageInfo.setPageNum(pageNum);
        pageInfo.setPageSize(pageSize);
        return tbUserMapper.query(pageInfo);
    }

    @Override
    public PageInfo<TbUser> getPageTbUser(int pageNum, int pageSize) {
        // 1. 使用PageInfo包装查询结果
        PageInfo<TbUser> pageInfo = new PageInfo<>();
        pageInfo.setPageNum(pageNum);
        pageInfo.setPageSize(pageSize);
        // 2. 总记录条数
        long total = tbUserMapper.count();
        pageInfo.setTotal(total);
        // 3. 分页结果集
        List<TbUser> list = tbUserMapper.query(pageInfo);
        pageInfo.setList(list);
        // 4. 返回
        return pageInfo;
    }
}
