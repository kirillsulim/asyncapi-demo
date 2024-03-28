package com.asyncapi;

  
  
import com.asyncapi.model.GreetingPayload;
  

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.IntegerDeserializer;
import org.apache.kafka.common.serialization.IntegerSerializer;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.kafka.support.serializer.JsonSerializer;
import org.springframework.kafka.test.EmbeddedKafkaBroker;
import org.springframework.kafka.test.rule.EmbeddedKafkaRule;
import org.springframework.kafka.test.utils.KafkaTestUtils;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.processing.Generated;
import java.time.Duration;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static org.springframework.test.util.AssertionErrors.assertEquals;

/**
 * Example of tests for kafka based on spring-kafka-test library
 */
@Generated(value="com.asyncapi.generator.template.spring", date="2024-03-28T11:36:11.443Z")
@RunWith(SpringRunner.class)
@SpringBootTest
public class SimpleKafkaTest {
      
    private static final String _PUBLISH_TOPIC = "hello";
     
    @ClassRule
    public static EmbeddedKafkaRule embeddedKafka = new EmbeddedKafkaRule(1, false, 1);

    private static EmbeddedKafkaBroker embeddedKafkaBroker = embeddedKafka.getEmbeddedKafka();

    @DynamicPropertySource
    public static void kafkaProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.kafka.bootstrap-servers", embeddedKafkaBroker::getBrokersAsString);
    }

     
    Producer<Integer, Object> producer;
    
    @Before
    public void init() {
         
        Map<String, Object> producerConfigs = new HashMap<>(KafkaTestUtils.producerProps(embeddedKafkaBroker));
        producer = new DefaultKafkaProducerFactory<>(producerConfigs, new IntegerSerializer(), new JsonSerializer()).createProducer();
        
    }
      
    @Test
    public void ConsumerTest() throws InterruptedException {
        Integer key = 1;  
        GreetingPayload payload = new GreetingPayload();

        ProducerRecord<Integer, Object> producerRecord = new ProducerRecord<>(_PUBLISH_TOPIC, key, payload);
        producer.send(producerRecord);
        producer.flush();
        Thread.sleep(1_000);
    }
        
    
}
