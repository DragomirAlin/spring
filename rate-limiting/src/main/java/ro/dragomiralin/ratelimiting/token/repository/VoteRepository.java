package ro.dragomiralin.ratelimiting.token.repository;

import org.springframework.stereotype.Component;
import ro.dragomiralin.ratelimiting.token.domain.Vote;

import java.util.ArrayList;
import java.util.List;

@Component
public class VoteRepository {
    private final List<Vote> votes = new ArrayList<>();

    public void addVote(Vote vote) {
        votes.add(vote);
    }

    public List<Vote> getVotes() {
        return votes;
    }
}
