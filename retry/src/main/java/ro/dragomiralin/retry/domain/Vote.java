package ro.dragomiralin.retry.domain;

import lombok.Builder;

@Builder
public record Vote(String candidateId, String voterId) {
}
