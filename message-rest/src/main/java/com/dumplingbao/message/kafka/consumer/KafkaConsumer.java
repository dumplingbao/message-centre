package com.dumplingbao.message.kafka.consumer;

import com.alibaba.fastjson.JSON;
import com.dumplingbao.message.core.KafkaTopic;
import com.dumplingbao.message.domain.Message;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @Author: dumplingbao
 * @Date: 2020/9/9 23:25
 */
@Component
@Slf4j
public class KafkaConsumer {

    @KafkaListener(topics = {KafkaTopic.TOPIC1})
    public void messageListene (ConsumerRecord<?, ?> consumerRecord) {
        Optional<?> kafkaMessage = Optional.ofNullable(consumerRecord.value());
        if (kafkaMessage.isPresent()) {
            String mamMessageStr = (String)kafkaMessage.get();
            Message message = JSON.parseObject(mamMessageStr, Message.class);
            log.info("partition: {}, thread: {}, emailMessage: {}", consumerRecord.partition(), Thread.currentThread().getName(), mamMessageStr);
        }
    }
}
