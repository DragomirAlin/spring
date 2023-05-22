package ro.dragomiralin.ratelimiting.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ro.dragomiralin.ratelimiting.domain.Vote;
import ro.dragomiralin.ratelimiting.repository.VoteRepository;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class VoteService {
    private final VoteRepository voteRepository;

    public void addVote(Vote vote) {
        log.info("Adding vote {} {}", countVotes(), vote);
        voteRepository.addVote(vote);
    }

    public List<Vote> getVotes() {
        return voteRepository.getVotes();
    }

    public long countVotes() {
        return voteRepository.getVotes().size();
    }
}
