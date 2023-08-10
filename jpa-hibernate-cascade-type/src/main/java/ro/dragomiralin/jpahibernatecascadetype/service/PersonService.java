package ro.dragomiralin.jpahibernatecascadetype.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.dragomiralin.jpahibernatecascadetype.repository.AddressRepository;
import ro.dragomiralin.jpahibernatecascadetype.repository.PersonRepository;

@Service
@RequiredArgsConstructor
public class PersonService {
    private final AddressRepository addressRepository;
    private final PersonRepository personRepository;
}
