package com.smalldogg.springkakfaexample.config;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaAdmin;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaTopicConfig {

    @Value(value = "${kafka.producer.bootstrap-server}")
    private String bootstrapAddress;

    @Value(value = "${kafka.producer.a-topic}")
    private String aTopic;

    @Value(value = "${kafka.producer.b-topic}")
    private String bTopic;

    @Value(value = "${kafka.producer.c-topic}")
    private String cTopic;

    @Bean
    public KafkaAdmin kafkaAdmin() {
        Map<String, Object> configs = new HashMap<>();
        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
        return new KafkaAdmin(configs);
    }

    @Bean
    public NewTopic aTopic() {
        return new NewTopic(aTopic,1,(short)1);
    }

    @Bean
    public NewTopic bTopic() {
        return new NewTopic(bTopic, 6, (short) 1);
    }

    @Bean
    public NewTopic cTopic() {
        return new NewTopic(cTopic, 1, (short) 1);
    }
}
