package com.dumplingbao.message.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Author: dumplingbao
 * @Date: 2020/9/7 17:32
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class Message extends BaseMessage {

    /**
     * 发信人
     */
    private String from;

    /**
     * 收信人
     */
    private String to;

    /**
     * 消息标题
     */
    private String title;

    /**
     * 消息内容
     */
    private String content;
}
