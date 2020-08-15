package com.ego.mapper;

import com.ego.entity.TbOrder;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TbOrderMapper {
    long countByExample(TbOrder example);

    int deleteByExample(TbOrder example);

    int deleteByPrimaryKey(String orderId);

    int insert(TbOrder record);

    int insertSelective(TbOrder record);

    List<TbOrder> selectByExample(TbOrder example);

    TbOrder selectByPrimaryKey(String orderId);

    int updateByExampleSelective(@Param("record") TbOrder record, @Param("example") TbOrder example);

    int updateByExample(@Param("record") TbOrder record, @Param("example") TbOrder example);

    int updateByPrimaryKeySelective(TbOrder record);

    int updateByPrimaryKey(TbOrder record);
}