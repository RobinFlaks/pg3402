package com.robin.buy;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class BuyRabbitMQConfig {
    @Bean
    public Queue collectionQueue(){
        return new Queue("exchangeName", false);
    }

    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange("directExchange");
    }

    @Bean
    public Binding binding(Queue collectionQueue, DirectExchange directExchange) {
        return BindingBuilder.bind(collectionQueue)
                .to(directExchange)
                .with("routingKey");
    }
}
