package ro.dragomiralin.springreactive.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import ro.dragomiralin.springreactive.domain.Warehouse;

@Repository
public interface WarehouseRepository extends ReactiveMongoRepository<Warehouse, String> {
}
