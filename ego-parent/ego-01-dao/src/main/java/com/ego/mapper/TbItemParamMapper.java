package com.ego.mapper;

import com.ego.entity.TbItemParam;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TbItemParamMapper {
    long countByExample(TbItemParam example);

    int deleteByExample(TbItemParam example);

    int deleteByPrimaryKey(Long id);

    int insert(TbItemParam record);

    int insertSelective(TbItemParam record);

    List<TbItemParam> selectByExampleWithBLOBs(TbItemParam example);

    List<TbItemParam> selectByExample(TbItemParam example);

    List<TbItemParam> selectItemPageList(@Param("pageNum") int pageNum, @Param("pageSize") int pageSize);

    TbItemParam selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TbItemParam record, @Param("example") TbItemParam example);

    int updateByExampleWithBLOBs(@Param("record") TbItemParam record, @Param("example") TbItemParam example);

    int updateByExample(@Param("record") TbItemParam record, @Param("example") TbItemParam example);

    int updateByPrimaryKeySelective(TbItemParam record);

    int updateByPrimaryKeyWithBLOBs(TbItemParam record);

    int updateByPrimaryKey(TbItemParam record);
}