package com.ego.mapper;

import com.ego.entity.TbItem;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author liuweiwei
 * @since 2020-08-31
 */
@Mapper
public interface TbItemMapper {
    long countByExample(TbItem example);

    int deleteByExample(TbItem example);

    int deleteByPrimaryKey(Long id);

    int insert(TbItem record) throws Exception;

    int insertSelective(TbItem record);

    List<TbItem> selectByExample(TbItem example);

    List<TbItem> selectAll();

    List<TbItem> selectItemPageList(@Param("pageNum") int pageNum, @Param("pageSize") int pageSize);

    TbItem selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TbItem record, @Param("example") TbItem example);

    int updateByExample(@Param("record") TbItem record, @Param("example") TbItem example);

    int updateByPrimaryKeySelective(TbItem record);

    int instock(@Param("item") TbItem record) throws Exception;

    int reshelf(@Param("id") Long id) throws Exception;

    int delete(@Param("item") TbItem record) throws Exception;

    long count();
}