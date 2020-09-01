package com.ego.controller;

import com.ego.entity.EasyUIPageVO;
import com.ego.entity.TbItemParam;
import com.ego.service.TbItemParamService;
import com.mangofactory.swagger.annotations.ApiIgnore;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author liuweiwei
 * @since 2020-8-15
 */
@Api(tags = "商品规则参数相关接口", description = "TbItemParamController")
@Controller
public class TbItemParamController {

    @Autowired
    protected TbItemParamService tbItemParamService;

    // http://localhost:8080/item/param/list?page=1&rows=10
    @ApiOperation(value = "查询商品规则参数", notes = "分页查询商品规则参数列表")
    @RequestMapping(value = "/item/param/list", method = RequestMethod.GET)
    @ResponseBody
    public EasyUIPageVO list(@ApiIgnore int page, @ApiIgnore int rows) {
        EasyUIPageVO result = tbItemParamService.list(page, rows);
        return result;
    }
}