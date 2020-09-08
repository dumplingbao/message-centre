package com.dumplingbao.message.controller;

import com.dumplingbao.message.core.BaseResponse;
import com.dumplingbao.message.domain.ApplicationInfo;
import com.dumplingbao.message.service.IApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: baomm
 * @Date: 2020/9/8 15:00
 */
@RestController
@RequestMapping(value = "/api/application")
public class ApplicationController {

    @Autowired
    private IApplicationService applicationService;

    @PostMapping
    public void save(@RequestBody ApplicationInfo applicationInfo){
        applicationService.saveOrUpdate(applicationInfo);
    }

    @GetMapping(value = "/{id}")
    public BaseResponse findById(@PathVariable("id") String id) {
        return BaseResponse.success(applicationService.findById(id));
    }

}
