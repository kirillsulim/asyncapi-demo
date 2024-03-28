package com.asyncapi;

  
 
import com.asyncapi.model.GreetingPayload;
 

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.IntegerDeserializer;
import org.apache.kafka.common.serialization.IntegerSerializer;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.support.serializer.JsonSerializer;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.testcontainers.containers.KafkaContainer;
import org.testcontainers.shaded.com.google.common.collect.Lists;

import javax.annotation.processing.Generated;
import java.time.Duration;
import java.util.*;

import static java.util.Collections.emptyList;
import static org.apache.kafka.clients.consumer.ConsumerConfig.*;
import static org.apache.kafka.clients.producer.ProducerConfig.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Example of tests for kafka based on testcontainers library
 */
@Generated(value="com.asyncapi.generator.template.spring", date="2024-03-28T11:36:11.459Z")
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestcontainerKafkaTest {

      
    private static final String _PUBLISH_TOPIC = "hello";
     
    @ClassRule
    public static KafkaContainer kafka = new KafkaContainer();
    
    @DynamicPropertySource
    public static void kafkaProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.kafka.bootstrap-servers", kafka::getBootstrapServers);
    }
      
    @Test
    public void ConsumerTestcontainers() throws Exception {
        Integer key = 1;
        GreetingPayload payload = new GreetingPayload();

        ProducerRecord<Integer, Object> producerRecord = new ProducerRecord<>(_PUBLISH_TOPIC, key, payload);

        sendMessage(producerRecord);

        Thread.sleep(1_000);
    }
    
    
    
    protected void sendMessage(ProducerRecord message) throws Exception {
        try (KafkaProducer<Integer, Object> kafkaProducer = createProducer()) {
            kafkaProducer.send(message).get();
        }
    }

    protected void sendMessage(String topic, Object message) throws Exception {
        try (KafkaProducer<Integer, Object> kafkaProducer = createProducer()) {
            kafkaProducer.send(new ProducerRecord<>(topic, message)).get();
        }
    }

    protected KafkaProducer<Integer, Object> createProducer() {
        return new KafkaProducer<>(getKafkaProducerConfiguration());
    }

    protected Map<String, Object> getKafkaProducerConfiguration() {
        Map<String, Object> configs = new HashMap<>();
        configs.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafka.getBootstrapServers());
        configs.put(KEY_SERIALIZER_CLASS_CONFIG, IntegerSerializer.class.getName());
        configs.put(VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class.getName());
        return configs;
    }
    
}
