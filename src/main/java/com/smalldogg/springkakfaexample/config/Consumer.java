package com.smalldogg.springkakfaexample.config;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {
    @KafkaListener(topics = "test")
    public void listenGroupFoo(String message) {
        System.out.println("message : " + message);
    }
}
