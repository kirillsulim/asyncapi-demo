package com.asyncapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import javax.annotation.processing.Generated;
import java.util.HashMap;
import java.util.Map;

@Generated(value="com.asyncapi.generator.template.spring", date="2024-03-28T11:36:11.573Z")
@Service
public class PublisherServiceImpl implements PublisherService {

    @Autowired
    private KafkaTemplate<Integer, Object> kafkaTemplate;

    private String replaceParameters(String topic, Map<String, String> parameters) {
        if (parameters != null) {
            String compiledTopic = topic;
            for (String key : parameters.keySet()) {
                compiledTopic = compiledTopic.replace("{" + key + "}", parameters.get(key));
            }
            return compiledTopic;
        }
        return topic;
    }
}
