package com.kumar.spring.kafka;

import com.kumar.spring.payload.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaProducer.class);
    private KafkaTemplate<String, User> kafkaTemplate;

    public JsonKafkaProducer(KafkaTemplate<String, User> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(User data){

     LOGGER.info(String.format("Message Sent ->  %s",data.toString()));
        // message building by org.springframework.messaging

        Message<User> message = MessageBuilder
                                .withPayload(data)
                                .setHeader(KafkaHeaders.TOPIC,"IRON_MAN1_JSON")
                                .build();
        // sending the message to the topic with kafka template
        kafkaTemplate.send(message);
    }
}
