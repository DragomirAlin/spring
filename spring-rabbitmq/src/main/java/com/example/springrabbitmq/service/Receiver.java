package com.example.springrabbitmq.service;

import com.example.springrabbitmq.model.Warehouse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Receiver {

    @RabbitListener(queues = "warehouse-01A")
    public void receiveMessage(String message) {
        log.info("warehouse-01A: Received <" + message + ">");
    }

    @RabbitListener(queues = "warehouse-02B")
    public void receiveMessage2(String message) {
        log.info("warehouse-02B: Received <" + message + ">");
    }

    @RabbitListener(queues = "warehouse-03C")
    public void receiveMessage3(String message) {
        log.info("warehouse-03C: Received <" + message + ">");
    }
}
