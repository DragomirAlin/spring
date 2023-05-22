package ro.dragomiralin.retry.service;

import io.github.resilience4j.core.EventPublisher;
import io.github.resilience4j.retry.annotation.Retry;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ro.dragomiralin.retry.domain.Vote;

import java.time.Instant;
import java.util.UUID;

import static java.lang.Thread.sleep;

@Slf4j
@Service
@RequiredArgsConstructor
public class VoterService {
    private final RestTemplate restTemplate;

    @Retry(name = "voter", fallbackMethod = "voteFallback")
    public ResponseEntity sendVoteWithRetry() {
        log.info("Sending vote... {}", Instant.now());
        var response = restTemplate.postForEntity("https://host/api-v1/elections",
                Vote.builder()
                        .voterId(UUID.randomUUID().toString())
                        .candidateId(UUID.randomUUID().toString())
                        .build(),
                ResponseEntity.class);
        log.info("Vote response {}: {}", response.getStatusCode(), response.getBody());
        return response;
    }

    public ResponseEntity voteFallback(Exception e) {
        log.error("Fallback: {}", e.getMessage());
        return ResponseEntity.ok("Fallback Response: %s".formatted(e.getMessage()));
    }

    public void sendVote() {
        log.info("Sending vote... {}", Instant.now());
        var response = restTemplate.postForEntity("https://host/api-v1/elections",
                Vote.builder()
                        .voterId(UUID.randomUUID().toString())
                        .candidateId(UUID.randomUUID().toString())
                        .build(),
                ResponseEntity.class);
        log.info("Vote response {}: {}", response.getStatusCode(), response.getBody());
    }
}
