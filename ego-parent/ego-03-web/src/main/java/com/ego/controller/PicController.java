package com.ego.controller;

import com.ego.service.PicService;
import com.mangofactory.swagger.annotations.ApiIgnore;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

/**
 * @author liuweiwei
 * @since 2020-8-15
 */
@Api(tags = "文件相关接口", description = "PicController")
@Controller
public class PicController {

    @Autowired
    private PicService picService;

    /**
     * Content Management System - 网站系统又名网站CMS系统，主要用途是为了节约网站开发的成本而开发的建站系统。
     * 文件上传功能
     *
     * @param uploadFile
     * @return
     * @throws IOException
     */
    // http://localhost:8848/pic/upload?dir=image
    @RequestMapping(value = "pic/upload")
    @ResponseBody
    @ApiOperation(notes = "文件上传", value = "文件上传处理列表")
    @ApiImplicitParam(name = "uploadFile", value = "多部分文件", required = false, dataType = "MultipartFile", paramType = "body")
    @ApiResponse(code = 200, message = "", response = Map.class)
    public Map<String, Object> upload(@RequestBody MultipartFile uploadFile) throws IOException {
        Map<String, Object> upload = picService.upload(uploadFile);
        return upload;
    }

}
