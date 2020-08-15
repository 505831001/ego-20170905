package com.ego.mapper;

import com.ego.entity.TbOrderShipping;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TbOrderShippingMapper {
    long countByExample(TbOrderShipping example);

    int deleteByExample(TbOrderShipping example);

    int deleteByPrimaryKey(String orderId);

    int insert(TbOrderShipping record);

    int insertSelective(TbOrderShipping record);

    List<TbOrderShipping> selectByExample(TbOrderShipping example);

    TbOrderShipping selectByPrimaryKey(String orderId);

    int updateByExampleSelective(@Param("record") TbOrderShipping record, @Param("example") TbOrderShipping example);

    int updateByExample(@Param("record") TbOrderShipping record, @Param("example") TbOrderShipping example);

    int updateByPrimaryKeySelective(TbOrderShipping record);

    int updateByPrimaryKey(TbOrderShipping record);
}