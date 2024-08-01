package com.kumar.spring.kafka;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class kafkaProducer {
    public static final Logger LOGGER =  LoggerFactory.getLogger(kafkaProducer.class);
    private KafkaTemplate<String,String> kafkaTemplate;

    public kafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String message){
        LOGGER.info(String.format("Message Sent %s",message));
        kafkaTemplate.send("IRON_MAN1",message);
    }

}
