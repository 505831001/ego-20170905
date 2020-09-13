package com.ego.controller;

import com.ego.entity.TbUser;
import com.ego.service.TbUserService;
import com.github.pagehelper.PageInfo;
import com.mangofactory.swagger.annotations.ApiIgnore;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Content Management System - 网站系统又名网站CMS系统，主要用途是为了节约网站开发的成本而开发的建站系统。
 *
 * @author liuweiwei
 * @since 2020-8-15
 */
@Api(tags = "用户管理相关接口", description = "TbUserController")
@RequestMapping(value = "/user")
@Controller
public class TbUserController {

    @Autowired
    private TbUserService tbUserService;

    @RequestMapping(value = "/query", method = RequestMethod.GET)
    @ApiOperation(notes = "查询", value = "query()")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "当前页码", dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "每页条数", dataType = "Integer", paramType = "query")
    })
    @ApiResponses({
            @ApiResponse(code = 200, message = "返回码:0-失败,1-成功", response = TbUser.class)
    })
    public List<TbUser> query(@ApiIgnore int pageNum, @ApiIgnore int pageSize) {
        List<TbUser> list = tbUserService.query(pageNum, pageSize);
        return list;
    }

    @RequestMapping(value = "/pageInfo", method = RequestMethod.GET)
    @ApiOperation(notes = "分页查询用户列表", value = "getPageTbUser()")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "当前页码", dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "每页条数", dataType = "Integer", paramType = "query")
    })
    public PageInfo<TbUser> pageInfo(@RequestParam(value = "pageNum", defaultValue = "0") int pageNum,
                                     @RequestParam(value = "pageSize", defaultValue = "4") int pageSize) {
        PageInfo<TbUser> pageInfo = tbUserService.getPageTbUser(pageNum, pageSize);
        return pageInfo;
    }
}