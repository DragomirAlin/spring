package ro.dragomiralin.bullkhead.domain;

import lombok.Builder;

@Builder
public record Payment(String id, double amount, String currency) {
}
