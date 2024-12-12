package javaBankDesignProject.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @PostMapping("/createCustomer")
    public String createCustomer(@RequestBody Customer customer) {
	customer = customerRepository.save(customer);
	return customer.toString(); // convert to JSON library!
    }
}