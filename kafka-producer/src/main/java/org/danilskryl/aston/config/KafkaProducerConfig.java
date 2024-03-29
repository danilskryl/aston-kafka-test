package org.danilskryl.aston.config;

import java.util.Map;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.danilskryl.aston.dto.ProductDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

@Configuration
public class KafkaProducerConfig {

  @Value("${spring.kafka.bootstrap-servers}")
  private String bootstrapServers;

  public Map<String, Object> producerConfigObject() {
    return Map.of(
        ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers,
        ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class,
        ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
  }

  @Bean
  public ProducerFactory<String, ProductDto> producerFactoryObject() {
    return new DefaultKafkaProducerFactory<>(producerConfigObject());
  }

  @Bean
  public KafkaTemplate<String, ProductDto> kafkaTemplateObject(
      ProducerFactory<String, ProductDto> producerFactoryObject) {
    return new KafkaTemplate<>(producerFactoryObject);
  }
}


//  public Map<String, Object> producerConfig() {
//    return Map.of(
//        ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers,
//        ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class,
//        ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
//  }
//
//  @Bean
//  public ProducerFactory<String, String> producerFactory() {
//    return new DefaultKafkaProducerFactory<>(producerConfig());
//  }
//
//  @Bean
//  public KafkaTemplate<String, String> kafkaTemplate(
//      ProducerFactory<String, String> producerFactory) {
//    return new KafkaTemplate<>(producerFactory);
//  }