package com.ego.controller;

import com.ego.entity.EasyUITree;
import com.ego.entity.TbContentCategory;
import com.ego.service.TbContentCategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Content Management System - 网站系统/CMS系统：主要用途是为了节约网站开发的成本而开发的建站系统。
 * <p>
 * 内容分类 控制器类
 * </p>
 *
 * @author liuweiwei
 * @since 2020-05-19
 */
@Controller
@Api(tags = "用户管理相关接口", description = "TbContentCategoryController")
public class TbContentCategoryController {
    /**
     * SLF4J 骚粉日志必备技能
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(TbContentCategoryController.class);

    @Autowired
    private TbContentCategoryService tbContentCategoryService;

    /**
     * 查询商品分类信息
     *
     * @return List<TbContentCategory>
     */
    // http://localhost:8080/content/category/list
    @RequestMapping(value = "/content/category/list", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "查询", notes = "查询商品分类信息")
    public List<EasyUITree> list(@RequestParam(defaultValue = "0") Long id) {
        List<EasyUITree> list = tbContentCategoryService.list(id);
        return list;
    }
}
