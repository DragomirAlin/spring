package ro.dragomiralin.circuitbreaker.controller;

import io.github.resilience4j.circuitbreaker.CallNotPermittedException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.dragomiralin.circuitbreaker.domain.Order;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api-v1/orders")
public class OrderController {

    @GetMapping
    @CircuitBreaker(name = "orders", fallbackMethod = "getOrdersFallback")
    public ResponseEntity<List<Order>> getOrders() {

        if (Math.random() < 0.5) {
            throw new RuntimeException("Failed to get orders");
        }

        return ResponseEntity.ok(List.of(Order.builder()
                        .id(UUID.randomUUID().toString())
                        .name("Order 1")
                        .description("Order 1 description")
                        .build(),
                Order.builder()
                        .id(UUID.randomUUID().toString())
                        .name("Order 2")
                        .description("Order 2 description")
                        .build()));
    }

    public ResponseEntity<String> getOrdersFallback(CallNotPermittedException e) {
        return ResponseEntity.internalServerError().body("Fallback method triggered - %s".formatted(e.getMessage()));
    }
}
