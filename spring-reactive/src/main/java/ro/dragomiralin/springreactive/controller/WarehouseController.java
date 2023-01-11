package ro.dragomiralin.springreactive.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ro.dragomiralin.springreactive.domain.Warehouse;
import ro.dragomiralin.springreactive.service.WarehouseService;

@RestController
@RequestMapping("/warehouse")
@RequiredArgsConstructor
public class WarehouseController {
    private final WarehouseService warehouseService;


    @GetMapping
    private Flux<Warehouse> list() {
        return warehouseService.list();
    }

    @GetMapping("/{id}")
    private Mono<Warehouse> get(@PathVariable String id) {
        return warehouseService.getById(id);
    }

    @PostMapping
    private Mono<Warehouse> create(@RequestBody Warehouse warehouse) {
        return warehouseService.create(warehouse);
    }
}
