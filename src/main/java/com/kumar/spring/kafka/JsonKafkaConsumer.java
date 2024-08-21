package com.kumar.spring.kafka;

import com.kumar.spring.payload.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaConsumer {
    public static final Logger LOGGER  = LoggerFactory.getLogger(JsonKafkaConsumer.class);
@KafkaListener(topics = "IRON_MAN1_JSON",groupId = "group1")
    public void consume(User user){
        LOGGER.info(String.format("JSon message received -> %s",user.toString()));
    }
}
