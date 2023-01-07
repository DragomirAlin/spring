package ro.dragomiralin.springreactive.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class Warehouse {
    private String id;
    private String name;
    private String capacity;
    private String employees;
}
