package ro.dragomiralin.springreactive.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document
@RequiredArgsConstructor
@AllArgsConstructor
public class Warehouse {
    private String id;
    private String name;
    private String capacity;
    private String employees;
}
