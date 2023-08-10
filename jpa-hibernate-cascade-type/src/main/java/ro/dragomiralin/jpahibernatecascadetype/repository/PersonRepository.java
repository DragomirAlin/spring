package ro.dragomiralin.jpahibernatecascadetype.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.dragomiralin.jpahibernatecascadetype.domain.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {
}
