package com.dumplingbao.message.kafka.producer;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @Author: dumplingbao
 * @Date: 2020/9/9 23:07
 */
@Component
@Slf4j
public class KafkaProducer {

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    /**
     * 将消息发送到kafka队列
     * @param topic
     * @param value
     */
    public void producerMessage(String topic, String value) {
        if (StringUtils.isBlank(topic) || StringUtils.isBlank(value)) {
            log.info("topic or value should not be null");
            return;
        }
        kafkaTemplate.send(topic, value);
    }

    /**
     * 将消息发送到kafka队列
     * @param topic
     * @param object
     */
    @Async
    public void producerMessage(String topic, Object object) {
        if (StringUtils.isBlank(topic) || object == null) {
            log.info("topic or object should not be null");
            return;
        }
        String value = null;
        try {
            value = JSON.toJSONString(object);
        } catch (Exception e) {
            log.error("object to json string error", e);
        }
        kafkaTemplate.send(topic, value);
    }
}
