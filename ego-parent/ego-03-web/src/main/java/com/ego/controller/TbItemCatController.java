package com.ego.controller;

import com.ego.entity.EasyUIPageVO;
import com.ego.entity.TbItemCat;
import com.ego.service.TbItemCatService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Content Management System - 网站系统又名网站CMS系统，主要用途是为了节约网站开发的成本而开发的建站系统。
 * <p>
 * 商品类目表 控制器类
 * </p>
 *
 * @author liuweiwei
 * @since 2020-8-15
 */
@Controller
@Api(tags = "物料类别管理相关接口", description = "TbItemCatController")
public class TbItemCatController {

    @Autowired
    private TbItemCatService tbItemCatService;

    // http://localhost:8080/item/cat/list
    @RequestMapping(value = "/item/cat/list")
    @ResponseBody
    @ApiOperation(value = "查询", notes = "查询物料品类列表")
    @ApiResponses({
            @ApiResponse(code = 200, message = "响应数据 成功返回1 失败返回0", response = TbItemCat.class)
    })
    public List<TbItemCat> list() {
        List<TbItemCat> list = tbItemCatService.list();
        return list;
    }
}
