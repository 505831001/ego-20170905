package com.ego.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Content Management System - 网站系统又名网站CMS系统，主要用途是为了节约网站开发的成本而开发的建站系统。
 *
 * @author liuweiwei
 * @since 2020-8-15
 */
@Controller
public class PageController {


    @RequestMapping(value = "/")
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/{path}")
    public String path(@PathVariable(value = "path") String path) {
        return path;
    }
}
