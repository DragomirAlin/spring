package ro.dragomiralin.jpahibernatecascadetype.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.dragomiralin.jpahibernatecascadetype.domain.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {
}
