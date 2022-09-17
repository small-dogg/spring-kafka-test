package com.smalldogg.springkakfaexample.controller;

import com.smalldogg.springkakfaexample.config.Producer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/a/{msg}")
    public void aHello(@PathVariable String msg) {
        producer.sendMessage("a","A : " + msg);
    }

    @GetMapping("/b/{msg}")
    public void bHello(@PathVariable String msg) {
        producer.sendMessage("b","B : " + msg);
    }

    @GetMapping("/c/{msg}")
    public void cHello(@PathVariable String msg) {
        producer.sendMessage("c","C : " + msg);
    }
}
