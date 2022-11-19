package ro.dragomiralin.springgraphql.configuration;

import org.springframework.context.annotation.Bean;
import ro.dragomiralin.springgraphql.dao.PostDao;
import ro.dragomiralin.springgraphql.model.Post;

import java.util.ArrayList;
import java.util.List;

public class DataSourceInit {

    @Bean
    public PostDao postDao() {
        List<Post> posts = new ArrayList<>();
        for (int postId = 0; postId < 10; ++postId) {
            for (int authorId = 0; authorId < 10; ++authorId) {
                var p = Post.builder()
                        .id("Post" + authorId + postId)
                        .title("Post " + authorId + ":" + postId)
                        .category("Post category")
                        .text("Post " + postId + " + by author " + authorId)
                        .authorId("Author" + authorId)
                        .build();
                posts.add(p);


            }
        }
        return new PostDao(posts);
    }
}
