package com.example.springbootdocker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class KafkaProducer {
    private static final Logger logger = LoggerFactory.getLogger(KafkaProducer.class);
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
    public void sendMessage(String message) {
        kafkaTemplate.send("test", String.valueOf(UUID.randomUUID()),message);
    }

}
