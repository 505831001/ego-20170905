package com.ego.controller;

import com.ego.entity.TbItemCat;
import com.ego.service.TbItemCatService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class TbItemCatController {

    @Autowired
    private TbItemCatService tbItemCatService;

    // http://localhost:8080/item/cat/list
    @ApiOperation(value = "物料品类", notes = "查询物料品类列表")
    @RequestMapping(value = "/item/cat/list")
    @ResponseBody
    public List<TbItemCat> list() {
        List<TbItemCat> list = tbItemCatService.list();
        return list;
    }
}
