package com.example.springrabbitmq.service;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Sender {
    private final RabbitTemplate rabbitTemplate;

    @Scheduled(fixedDelay = 1000)
    public void send() {
        rabbitTemplate.convertAndSend("warehouse.direct", "directRoutingKey", "Supplier has sent a new product");
    }


}
