package ro.dragomiralin.ratelimiting.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.dragomiralin.ratelimiting.domain.Vote;
import ro.dragomiralin.ratelimiting.repository.VoteRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VoteService {
    private final VoteRepository voteRepository;

    public void addVote(Vote vote) {
        voteRepository.addVote(vote);
    }

    public List<Vote> getVotes() {
        return voteRepository.getVotes();
    }
}
