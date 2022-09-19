package com.smalldogg.config;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {
    @KafkaListener(topics = "test")
    public void listenGroupFoo(String message) {
        System.out.println("message : " + message);
    }
    @KafkaListener(topics = "a")
    public void listenA(String message) {
        System.out.println("message : " + message);
    }
    @KafkaListener(topics = "b")
    public void listenB(String message) {
        System.out.println("message : " + message);
    }
    @KafkaListener(topics = "c")
    public void listenC(String message) {
        System.out.println("message : " + message);
    }
    @KafkaListener(topics = "topic1")
    public void listenTopic1(String message) {
        System.out.println("message : " + message);
    }
    @KafkaListener(topics = "topic2")
    public void listenTopic2(String message) {
        System.out.println("message : " + message);
    }
}
