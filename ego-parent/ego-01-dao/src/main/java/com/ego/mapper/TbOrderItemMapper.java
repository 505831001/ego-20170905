package com.ego.mapper;

import com.ego.entity.TbOrderItem;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TbOrderItemMapper {
    long countByExample(TbOrderItem example);

    int deleteByExample(TbOrderItem example);

    int deleteByPrimaryKey(String id);

    int insert(TbOrderItem record);

    int insertSelective(TbOrderItem record);

    List<TbOrderItem> selectByExample(TbOrderItem example);

    TbOrderItem selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbOrderItem record, @Param("example") TbOrderItem example);

    int updateByExample(@Param("record") TbOrderItem record, @Param("example") TbOrderItem example);

    int updateByPrimaryKeySelective(TbOrderItem record);

    int updateByPrimaryKey(TbOrderItem record);
}