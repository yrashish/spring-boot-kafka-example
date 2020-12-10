package com.example.springbootdocker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaController {

    private KafkaProducer kafkaProducer;
    @Autowired
    public KafkaController(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping("/kafka")
    private String getMessage(String message){
        kafkaProducer.sendMessage(message);
        return message;
    }

}
