package ro.dragomiralin.springgraphql.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class Post {
    private String id;
    private String title;
    private String category;
    private String text;
    private String authorId;
}

