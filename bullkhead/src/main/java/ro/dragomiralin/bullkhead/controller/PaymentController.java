package ro.dragomiralin.bullkhead.controller;

import io.github.resilience4j.bulkhead.BulkheadFullException;
import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.dragomiralin.bullkhead.domain.Payment;

import java.util.List;

@RestController
@RequestMapping("/api-v1/payments")
public class PaymentController {

    @GetMapping
    @Bulkhead(name = "paymentBulkheadApi")
    public List<Payment> getPayments() {

        return List.of(Payment.builder().id("1").amount(100).currency("EUR").build(),
                Payment.builder().id("2").amount(200).currency("EUR").build(),
                Payment.builder().id("3").amount(300).currency("EUR").build());
    }

    public ResponseEntity<String> bulkheadFallback(BulkheadFullException ex) {
        return ResponseEntity.status(HttpStatus.BANDWIDTH_LIMIT_EXCEEDED)
                .body("Too many request - No further calls are accepted. %s".formatted(ex.getMessage()));
    }
}

