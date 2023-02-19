package ro.dragomiralin.springbatch.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.dragomiralin.springbatch.customer.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
