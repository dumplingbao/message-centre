package com.dumplingbao.message.domain;

import com.dumplingbao.message.core.Page;
import com.dumplingbao.message.enums.MessageTypeEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Author: dumplingbao
 * @Date: 2020/9/7 17:08
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class BaseMessage extends Page {

    /**
     * appKey
     */
    private String appKey;

    /**
     * 消息类型
     */
    private MessageTypeEnum messageType;

    /**
     * 请求时间
     */
    private Long createTime = System.currentTimeMillis();

    public BaseMessage() {
    }

    public BaseMessage(MessageTypeEnum messageType) {
        this.messageType = messageType;
    }

}
