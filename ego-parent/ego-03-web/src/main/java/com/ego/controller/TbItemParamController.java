package com.ego.controller;

import com.ego.entity.EasyResult;
import com.ego.entity.EasyUIPageVO;
import com.ego.entity.TbItemParam;
import com.ego.service.TbItemCatService;
import com.ego.service.TbItemParamService;
import com.mangofactory.swagger.annotations.ApiIgnore;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import java.util.Date;

/**
 * Content Management System - 网站系统又名网站CMS系统，主要用途是为了节约网站开发的成本而开发的建站系统。
 * <p>
 * 商品参数表 控制器类
 * </p>
 *
 * @author liuweiwei
 * @since 2020-8-15
 */
@Controller
@Api(tags = "物料参数管理相关接口", description = "TbItemParamController")
public class TbItemParamController {

    @Autowired
    protected TbItemParamService tbItemParamService;

    @Autowired
    protected TbItemCatService tbItemCatService;

    /**
     * 分页查询商品参数信息
     *
     * @param page 页数
     * @param rows 行数
     * @return EasyUIPageVO 分页返回类
     */
    // http://localhost:8080/item/param/list?page=1&rows=10
    @RequestMapping(value = "/item/param/list", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "查询", notes = "分页查询商品规则参数列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "页数", defaultValue = "1", dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "rows", value = "行数", defaultValue = "10", dataType = "Integer", paramType = "query")
    })
    @ApiResponses({
            @ApiResponse(code = 200, message = "响应数据 成功返回1 失败返回0", response = EasyUIPageVO.class)
    })
    public EasyUIPageVO list(@ApiIgnore int page, @ApiIgnore int rows) {
        EasyUIPageVO result = tbItemParamService.list(page, rows);
        return result;
    }

    /**
     * 查询商品品类信息
     *
     * @param catId
     * @return EasyResult
     */
    // http://localhost:8080/item/param/query/itemcatid/1
    @RequestMapping(value = "/item/param/query/itemcatid/{catId}", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "查询", notes = "查询商品品类列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "catId", value = "品类ID", required = true, dataType = "Long", paramType = "query")
    })
    @ApiResponses({
            @ApiResponse(code = 200, message = "响应数据 成功-1 失败-0", response = EasyResult.class)
    })
    public EasyResult query(@PathVariable(value = "catId") Long catId) {
        EasyResult result = tbItemCatService.query(catId);
        return result;
    }

    /**
     * 保存商品参数信息
     *
     * @param catId
     * @param paramData
     * @return EasyResult
     */
    // http://localhost:8080/item/param/save/1
    @RequestMapping(value = "/item/param/save/{catId}", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "保存", notes = "保存商品参数信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "paramData", value = "参数JSON串串", dataType = "String", paramType = "form"),
            @ApiImplicitParam(name = "catId", value = "品类ID", dataType = "Long", paramType = "form")
    })
    @ApiResponses({
            @ApiResponse(code = 200, message = "响应数据 成功-1 失败-0", response = EasyResult.class)
    })
    public EasyResult save(@PathVariable("catId") Long catId, @ApiIgnore String paramData) {
        TbItemParam record = new TbItemParam();
        record.setItemCatId(catId);
        record.setCreated(new Date());
        record.setUpdated(new Date());
        record.setParamData(paramData);
        EasyResult result = tbItemParamService.save(record);
        return result;
    }

    /**
     * 批量删除商品参数信息
     *
     * @param ids
     * @return int
     */
    // http://localhost:8080/item/param/delete
    @RequestMapping(value = "/item/param/delete", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "删除", notes = "批量删除商品参数")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ids", value = "主键ID", required = true, dataType = "Long[]", paramType = "query")
    })
    @ApiResponses({
            @ApiResponse(code = 200, message = "响应数据 成功-1 失败-0", response = Integer.class)
    })
    public int deleteBatch(Long[] ids) {
        int index = tbItemParamService.deleteBatch(ids);
        return index;
    }
}