package com.smalldogg.springkakfaexample.config;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.kafka.core.KafkaProducerException;
import org.springframework.kafka.core.KafkaSendCallback;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Component
public class Producer {
    private final KafkaTemplate<String, String> kafkaTemplate;

    public Producer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String topic, String payload) {
        ListenableFuture<SendResult<String, String>> listenableFuture = kafkaTemplate.send(topic, payload);
    }

    public void sendMessage(String topic, String payload, String mode){
        ListenableFuture<SendResult<String, String>> listenableFuture = kafkaTemplate.send(topic, payload);
        if(mode=="raw") {
            listenableFuture.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
                @Override
                public void onFailure(Throwable ex) {
                    System.out.println(ex.getMessage());
                }

                @Override
                public void onSuccess(SendResult<String, String> result) {
                    System.out.println("onSuccess -> " + result.toString());
                }
            });
        }else{
            listenableFuture.addCallback(new KafkaSendCallback<String, String>() {
                @Override
                public void onSuccess(SendResult<String, String> result) {
                    System.out.println("onSuccess -> " + result.toString());
                }

                @Override
                public void onFailure(KafkaProducerException ex) {
                    ProducerRecord<Integer, String> failed = ex.getFailedProducerRecord();
                    System.out.println(failed.toString());
                }
            });
        }
    }
}
