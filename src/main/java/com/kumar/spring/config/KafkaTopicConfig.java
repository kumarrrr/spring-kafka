package com.kumar.spring.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {
    @Value("${spring.kafka.topic-plain.name}")
    private String topicName;
    @Bean
    public NewTopic netflixTopics(){
        return TopicBuilder.name(topicName).build();
    }

    @Bean
    public NewTopic netflixJsonTopics(){
        return TopicBuilder.name("IRON_MAN1_JSON").build();
    }
}
