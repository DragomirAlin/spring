package com.example.springrabbitmq.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitMqConfiguration {

    @Bean
    Queue warehouseA() {
        return new Queue("warehouse-01A", false, false, true);
    }

    @Bean
    Queue warehouseB() {
        return new Queue("warehouse-02B", false, false, true);
    }

    @Bean
    Queue warehouseC() {
        return new Queue("warehouse-03C", false, false, true);
    }

    @Bean
    TopicExchange exchange() {
        return new TopicExchange("warehouse");
    }

    @Bean
    FanoutExchange fanoutExchange() {
        return new FanoutExchange("warehouse.fanout");
    }

    @Bean
    DirectExchange directExchange() {
        return new DirectExchange("warehouse.direct");
    }

    @Bean
    Binding directBinding(Queue warehouseA, DirectExchange exchange) {
        return BindingBuilder.bind(warehouseA).to(exchange).with("directRoutingKey");
    }

    @Bean
    Binding fanoutBindingA(Queue warehouseA, FanoutExchange exchange) {
        return BindingBuilder.bind(warehouseA).to(exchange);
    }

    @Bean
    Binding fanoutBindingB(Queue warehouseB, FanoutExchange exchange) {
        return BindingBuilder.bind(warehouseB).to(exchange);
    }

    @Bean
    Binding fanoutBindingC(Queue warehouseC, FanoutExchange exchange) {
        return BindingBuilder.bind(warehouseC).to(exchange);
    }

    @Bean
    Binding bindingA(Queue warehouseA, TopicExchange exchange) {
        return BindingBuilder.bind(warehouseA).to(exchange).with("warehouse.eu.*");
    }

    @Bean
    Binding bindingB(Queue warehouseB, TopicExchange exchange) {
        return BindingBuilder.bind(warehouseB).to(exchange).with("warehouse.us.*");
    }

    @Bean
    Binding bindingC(Queue warehouseC, TopicExchange exchange) {
        return BindingBuilder.bind(warehouseC).to(exchange).with("warehouse.de.*");
    }

    @Bean
    public RabbitTemplate rabbitTemplate(final ConnectionFactory connectionFactory) {
        final var rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(producerJackson2MessageConverter());
        return rabbitTemplate;
    }

    @Bean
    public Jackson2JsonMessageConverter producerJackson2MessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public RabbitAdmin rabbitAdmin(final ConnectionFactory connectionFactory) {
        return new RabbitAdmin(connectionFactory);
    }
}
