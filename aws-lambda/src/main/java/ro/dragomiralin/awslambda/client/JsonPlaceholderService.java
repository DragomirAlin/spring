package ro.dragomiralin.awslambda.client;

import org.springframework.web.service.annotation.GetExchange;
import ro.dragomiralin.awslambda.domain.Post;

import java.util.List;

public interface JsonPlaceholderService {

    @GetExchange("/posts")
    List<Post> loadPosts();
}
