package com.dumplingbao.message.service.impl;

import com.dumplingbao.message.core.KafkaTopic;
import com.dumplingbao.message.domain.Message;
import com.dumplingbao.message.kafka.producer.KafkaProducer;
import com.dumplingbao.message.service.IMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: dumplingbao
 * @Date: 2020/9/14 17:05
 */
@Service
public class MessageServiceImpl implements IMessageService {

    @Autowired
    KafkaProducer kafkaProducer;

    @Override
    public String pushMessage(Message message) {
        kafkaProducer.producerMessage(KafkaTopic.TOPIC1, message);
        return "发送成功";
    }
}
