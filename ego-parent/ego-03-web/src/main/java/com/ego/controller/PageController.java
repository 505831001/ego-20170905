package com.ego.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
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
