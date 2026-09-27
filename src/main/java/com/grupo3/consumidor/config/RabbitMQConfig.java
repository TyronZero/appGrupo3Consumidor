package com.grupo3.consumidor.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String QUEUE = "Grupo3Queue";
    public static final String EXCHANGE = "Grupo3Exchange";
    public static final String ROUTING_KEY = "Grupo3Routing";

    @Bean
    public Queue grupo3Queue() {
        return new Queue(QUEUE, true);
    }

    @Bean
    public DirectExchange grupo3Exchange() {
        return new DirectExchange(EXCHANGE);
    }

    @Bean
    public Binding grupo3Binding(Queue grupo3Queue, DirectExchange grupo3Exchange) {
        return BindingBuilder
                .bind(grupo3Queue)
                .to(grupo3Exchange)
                .with(ROUTING_KEY);
    }
}
