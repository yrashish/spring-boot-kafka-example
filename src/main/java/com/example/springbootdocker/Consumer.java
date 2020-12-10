package com.example.springbootdocker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer {
    private static final Logger logger = LoggerFactory.getLogger(Consumer.class);
    @KafkaListener(topics = "test",groupId = "test_id")
    private void consumeMessage(String message){
        logger.info("Message received "+ message);
    }

}
