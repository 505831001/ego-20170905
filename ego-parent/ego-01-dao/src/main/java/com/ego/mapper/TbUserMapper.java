package com.ego.mapper;

import com.ego.entity.TbUser;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface TbUserMapper {
    List<TbUser> query(PageInfo pageInfo);

    long count();

    List<TbUser> selectAll();
}