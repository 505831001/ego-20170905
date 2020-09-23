package com.ego.mapper;

import com.ego.entity.TbContentCategory;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TbContentCategoryMapper {
    long countByExample(TbContentCategory example);

    int deleteByExample(TbContentCategory example);

    int deleteByPrimaryKey(Long id);

    int insert(TbContentCategory record);

    int insertSelective(TbContentCategory record);

    List<TbContentCategory> selectByExample(TbContentCategory example);

    TbContentCategory selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TbContentCategory record, @Param("example") TbContentCategory example);

    int updateByExample(@Param("record") TbContentCategory record, @Param("example") TbContentCategory example);

    int updateByPrimaryKeySelective(TbContentCategory record);

    int updateByPrimaryKey(TbContentCategory record);

    List<TbContentCategory> selectAll(@Param("parentId") Long id);
}