package com.flipkart.configration;

import java.util.Map;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

import com.flipkart.constant.ApplicationConstant;

@Configuration
public class KafkaConfig {
	
	

    @Bean
    NewTopic newTopic() {
		return TopicBuilder.name(ApplicationConstant.TOPICS_NAME)
				.partitions(1)
				.replicas(1)
				.configs(Map.of("min.insync.replicas","1"))
				.build();
	}

}
