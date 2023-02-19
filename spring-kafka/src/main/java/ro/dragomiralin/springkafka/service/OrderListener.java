package ro.dragomiralin.springkafka.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class OrderListener {

    @KafkaListener(topics = "orders", groupId = "foo")
    public void listenGroupFoo(String message) {
        log.info("Received Message in group foo: {}", message);
    }
}
