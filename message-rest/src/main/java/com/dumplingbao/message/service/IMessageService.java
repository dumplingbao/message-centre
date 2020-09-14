package com.dumplingbao.message.service;

import com.dumplingbao.message.domain.Message;

/**
 * @author dumplingbao
 */
public interface IMessageService {

    String pushMessage(Message message);
}
