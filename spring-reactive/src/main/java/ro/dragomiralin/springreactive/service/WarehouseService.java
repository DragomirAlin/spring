package ro.dragomiralin.springreactive.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ro.dragomiralin.springreactive.domain.Warehouse;
import ro.dragomiralin.springreactive.repository.WarehouseRepository;

@Service
@RequiredArgsConstructor
public class WarehouseService {
    private final WarehouseRepository warehouseRepository;

    public Mono<Warehouse> create(Warehouse warehouse) {
       return warehouseRepository.save(warehouse);
    }

    public Mono<Warehouse> update(Warehouse warehouse) {
        return warehouseRepository.save(warehouse);
    }

    public Mono<Void> delete(String id) {
        return warehouseRepository.deleteById(id);
    }

    public Flux<Warehouse> list() {
        return warehouseRepository.findAll();
    }

    public Mono<Warehouse> getById(String id) {
        return warehouseRepository.findById(id);
    }
}
