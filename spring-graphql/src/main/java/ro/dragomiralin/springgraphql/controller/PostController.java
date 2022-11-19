package ro.dragomiralin.springgraphql.controller;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import ro.dragomiralin.springgraphql.dao.PostDao;
import ro.dragomiralin.springgraphql.model.Post;

import java.util.List;

@Controller
public class PostController {

    private PostDao postDao;

    @QueryMapping
    public List<Post> recentPosts(@Argument int count, @Argument int offset) {
        return postDao.getRecentPosts(count, offset);
    }
}