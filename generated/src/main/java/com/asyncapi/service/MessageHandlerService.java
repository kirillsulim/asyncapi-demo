package com.asyncapi.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.asyncapi.model.GreetingPayload;

import javax.annotation.processing.Generated;
import java.util.ArrayList;
import java.util.List;

@Generated(value="com.asyncapi.generator.template.spring", date="2024-03-28T11:36:11.537Z")
@Service
public class MessageHandlerService {
    private static final Logger LOGGER = LoggerFactory.getLogger(MessageHandlerService.class);


        
        
    
    @KafkaListener(topics = "hello")
    public void (@Payload GreetingPayload payload,
                       @Header(KafkaHeaders.RECEIVED_TOPIC) String topic,
                       @Header(KafkaHeaders.RECEIVED_KEY) Integer key,
                       @Header(KafkaHeaders.RECEIVED_PARTITION) int partition,
                       @Header(KafkaHeaders.RECEIVED_TIMESTAMP) long timestamp) {
        LOGGER.info("Key: " + key + ", Payload: " + payload.toString() + ", Timestamp: " + timestamp + ", Partition: " + partition);
    }
    


}
