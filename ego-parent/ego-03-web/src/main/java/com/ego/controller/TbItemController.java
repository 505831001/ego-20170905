package com.ego.controller;

import com.ego.entity.EasyUIPageVO;
import com.ego.entity.TbItem;
import com.ego.service.TbItemService;
import com.github.pagehelper.PageInfo;
import com.mangofactory.swagger.annotations.ApiIgnore;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author liuweiwei
 * @since 2020-8-15
 */
@Api(tags = "物料管理相关接口", description = "TbItemController")
@Controller
public class TbItemController {

    protected final Logger LOGGER = LoggerFactory.getLogger(TbItemController.class);

    @Autowired
    protected TbItemService tbItemService;

    // http://localhost:8848/item/list?page=1&rows=30
    @RequestMapping(value = "/item/list")
    @ResponseBody
    @ApiOperation(notes = "物料列表", value = "分页查询物料列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "当前页码", required = false, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "rows", value = "每页条数", required = false, dataType = "int", paramType = "query")
    })
    @ApiResponse(code = 200, message = "返回码:0-失败,1-成功", response = TbItem.class)
    public EasyUIPageVO list(@RequestParam(value = "page", defaultValue = "0") int pageNum,
                             @RequestParam(value = "rows", defaultValue = "10") int pageSize) {
        EasyUIPageVO list = tbItemService.list(pageNum, pageSize);
        return list;
    }

    // http://localhost:8080/item/query?page=1&rows=30
    @RequestMapping(value = "/item/query")
    @ApiOperation(notes = "物料信息", value = "分页查询物料信息")
    @ResponseBody
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "当前页码", required = false, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "每页条数", required = false, dataType = "int", paramType = "query")
    })
    @ApiResponse(code = 200, message = "返回码:0-失败,1-成功", response = TbItem.class)
    public PageInfo<TbItem> query(@ApiIgnore int pageNum, @ApiIgnore int pageSize) {
        PageInfo<TbItem> pageInfo = tbItemService.query(pageNum, pageSize);
        return pageInfo;
    }

    // http://localhost:8080/rest/item/reshelf
    @ApiOperation(value = "上架物料", notes = "商品状态:1-正常,2-下架,3-删除")
    @RequestMapping(value = "/rest/item/reshelf")
    @ResponseBody
    public Integer reshelf(@RequestParam(value = "ids") String ids) {
        int status = 0;
        try {
            status = tbItemService.reshelf(ids);
        } catch (Exception e) {
            LOGGER.info("在控制器层捕获异常Consumer端，Dubbo RPC服务在Provider端抛出异常。" + e.getLocalizedMessage());
            e.printStackTrace();
        }
        return status;
    }

    // http://localhost:8080/rest/item/instock
    @ApiOperation(value = "下架物料", notes = "商品状态:1-正常,2-下架,3-删除")
    @RequestMapping(value = "/rest/item/instock")
    @ResponseBody
    public Integer instock(@RequestParam(value = "ids") String ids) {
        int status = 0;
        try {
            status = tbItemService.instock(ids);
        } catch (Exception e) {
            LOGGER.info("在控制器层捕获异常Consumer端，Dubbo RPC服务在Provider端抛出异常。" + e.getLocalizedMessage());
            e.printStackTrace();
        }
        return status;
    }

    // http://localhost:8080/rest/item/delete
    @ApiOperation(value = "删除物料", notes = "商品状态:1-正常,2-下架,3-删除")
    @RequestMapping(value = "/rest/item/delete")
    @ResponseBody
    public Integer delete(@RequestParam(value = "ids") String ids) {
        int status = 0;
        try {
            status = tbItemService.delete(ids);
        } catch (Exception e) {
            LOGGER.info("在控制器层捕获异常Consumer端，Dubbo RPC服务在Provider端抛出异常。" + e.getLocalizedMessage());
            e.printStackTrace();
        }
        return status;
    }

    /**
     * cid: 1
     * title: 标题01
     * sellPoint: 商品卖点01
     * priceView: 88.00
     * price: 8800
     * num: 100
     * barcode: 210201000098
     * image:
     * desc: 商品描述01
     * itemParams: []
     */
    // http://localhost:8848/item/save
    @RequestMapping(value = "/item/save")
    @ApiOperation(value = "新增物料", notes = "商品:cid,title,sellPoint,priceView,price,num,barcode,image,desc,itemParams")
    public Integer save(@RequestBody TbItem item,@RequestParam String desc) {
        int status = 0;
        try {
            status = tbItemService.save(item, desc);
        } catch (Exception e) {
            LOGGER.info("在控制器层捕获异常Consumer端，Dubbo RPC服务在Provider端抛出异常。" + e.getLocalizedMessage());
            e.printStackTrace();
        }
        return status;
    }
}
