package ro.dragomiralin.retry.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import ro.dragomiralin.retry.domain.Vote;
import ro.dragomiralin.retry.service.VoterService;

@RestController
@RequestMapping("/api-v1/votes")
@RequiredArgsConstructor
public class VoterController {
    private final VoterService voterService;

    @PostMapping("/send")
    public void sendVote() {
        voterService.sendVote();
    }

    @PostMapping("/send-with-retry")
    public void sendVoteWithRetry() {
        voterService.sendVoteWithRetry();
    }
}
