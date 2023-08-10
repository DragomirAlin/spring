package ro.dragomiralin.jpahibernatecascadetype;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ro.dragomiralin.jpahibernatecascadetype.domain.Address;
import ro.dragomiralin.jpahibernatecascadetype.domain.Person;
import ro.dragomiralin.jpahibernatecascadetype.repository.AddressRepository;
import ro.dragomiralin.jpahibernatecascadetype.repository.PersonRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class CascadeTypeTests {
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private PersonRepository personRepository;

    @Test
    public void test() {
        Address address = Address.builder()
                .houseNumber(12)
                .city("Brasov")
                .zipCode(500000)
                .street("Muresenilor")
                .build();

        Person person = Person.builder()
                .name("Alin")
                .addresses(List.of(address))
                .build();

        Person createdPerson = personRepository.save(person);
        assertNotNull(createdPerson);
        assertEquals(1, createdPerson.getAddresses().size());
    }

}
