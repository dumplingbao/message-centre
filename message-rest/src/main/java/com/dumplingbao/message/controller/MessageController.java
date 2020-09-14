package com.dumplingbao.message.controller;

import com.dumplingbao.message.core.BaseResponse;
import com.dumplingbao.message.domain.Message;
import com.dumplingbao.message.service.IMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: dumplingbao
 * @Date: 2020/9/14 17:01
 */
@RestController
@RequestMapping("/api/message")
public class MessageController {

    @Autowired
    private IMessageService messageService;

    /**
     * 健康检查接口
     *
     * @return
     */
    @RequestMapping(value = "/checkHealth", method = RequestMethod.HEAD)
    public BaseResponse checkHealth() {
        return BaseResponse.success();
    }

    @PostMapping(value = "/pushMessage")
    public BaseResponse pushMessage (@RequestBody Message message) {

        return BaseResponse.success(messageService.pushMessage(message));
    }


}
