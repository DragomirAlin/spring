package ro.dragomiralin.circuitbreaker.domain;

import lombok.Builder;

@Builder
public record Order(String id, String name, String description) {
}
