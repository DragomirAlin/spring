package ro.dragomiralin.springbatch.customer.config;

import org.springframework.batch.item.ItemProcessor;
import ro.dragomiralin.springbatch.customer.model.Customer;

public class CustomerProcessor implements ItemProcessor<Customer, Customer> {
    @Override
    public Customer process(Customer customer) throws Exception {
        return customer;
    }
}
