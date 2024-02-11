package org.danilskryl.aston.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaConfig {

  @Bean
  public NewTopic newProductTopic() {
    return TopicBuilder.name("new-product")
        .build();
  }

  @Bean
  public NewTopic newMarketTopic() {
    return TopicBuilder.name("new-market")
        .build();
  }

  @Bean
  public NewTopic transferProductInfo() {
    return TopicBuilder.name("transfer-product-info")
        .build();
  }
}
