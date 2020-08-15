package com.ego.controller;

import com.ego.entity.EasyUIPageVO;
import com.ego.entity.TbItemParam;
import com.ego.service.TbItemParamService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Api(tags = "商品规则参数相关接口")
@Controller
public class TbItemParamController {

    @Autowired
    private TbItemParamService tbItemParamService;

    // http://localhost:8080/item/param/list?page=1&rows=30
    @ApiOperation(value = "查询商品规则参数", notes = "分页查询商品规则参数列表")
    @RequestMapping(value = "/item/param/list")
    @ResponseBody
    public EasyUIPageVO list(@RequestParam(value = "page") int pageNum, @RequestParam(value = "rows") int pageSize) {
        EasyUIPageVO itemList = tbItemParamService.list(pageNum, pageSize);
        return itemList;
    }
}