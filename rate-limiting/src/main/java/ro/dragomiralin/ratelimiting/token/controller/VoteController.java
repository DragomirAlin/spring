package ro.dragomiralin.ratelimiting.token.controller;

import io.github.resilience4j.ratelimiter.RequestNotPermitted;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.dragomiralin.ratelimiting.token.domain.Vote;
import ro.dragomiralin.ratelimiting.token.service.VoteService;

import java.util.List;

@RestController
@RequestMapping("/api-v1/votes")
@RequiredArgsConstructor
public class VoteController {
    private final VoteService voteService;

    @PostMapping
    public void sendVote(@RequestBody Vote vote) {
        voteService.addVote(vote);
    }

    @GetMapping
    @RateLimiter(name = "votes", fallbackMethod = "getVotesFallback")
    public ResponseEntity<List<Vote>> getVotes() {
        return ResponseEntity.ok(voteService.getVotes());
    }

    public ResponseEntity<String> getVotesFallback(RequestNotPermitted e) {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Retry-After", "60s");

        return ResponseEntity.status(HttpStatus.TOO_MANY_REQUESTS)
                .headers(responseHeaders)
                .body("Too Many Requests - %s".formatted(e.getMessage()));
    }


}
