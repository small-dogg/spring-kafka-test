package com.smalldogg.springkakfaexample.controller;

import com.smalldogg.springkakfaexample.config.Producer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    private final Producer producer;

    public HelloController(Producer producer) {
        this.producer = producer;
    }

    @GetMapping("/")
    public void hello() {
        producer.sendMessage("test","Hello Everyone");
    }
}
