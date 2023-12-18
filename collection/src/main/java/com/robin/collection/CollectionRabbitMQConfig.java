package com.robin.collection;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class CollectionRabbitMQConfig {
    @Bean
    public Queue collectionQueue(){
        return new Queue("exchangeName", false);
    }
}
