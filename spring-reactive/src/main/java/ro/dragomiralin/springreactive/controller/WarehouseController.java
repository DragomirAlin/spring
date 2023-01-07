package ro.dragomiralin.springreactive.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ro.dragomiralin.springreactive.domain.Warehouse;

import java.util.List;

@RestController
@RequestMapping("/warehouse")
public class WarehouseController {
    private Flux<Warehouse> warehouses = Flux.just(
            Warehouse.builder().id("1").name("Warehouse 1").capacity("100").employees("10").build(),
            Warehouse.builder().id("2").name("Warehouse 2").capacity("200").employees("20").build(),
            Warehouse.builder().id("3").name("Warehouse 3").capacity("300").employees("30").build()
    );

    @GetMapping
    private Flux<Warehouse> list() {
        return warehouses;
    }

    @GetMapping("/{id}")
    private Mono<Warehouse> get(@PathVariable String id) {
        return warehouses.filter(warehouse -> warehouse.getId().equals(id)).next();
    }
}
