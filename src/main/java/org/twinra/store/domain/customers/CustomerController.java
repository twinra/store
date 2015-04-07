package org.twinra.store.domain.customers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.twinra.store.exceptions.ResourceNotFoundException;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class CustomerController {

	@Resource
	private CustomerRepository customerRepository;

	@RequestMapping("/customers")
	public List<Customer> getCustomers() {
		return new ArrayList<>(customerRepository.get().values());
	}

	@RequestMapping("/customers/{name}")
	public Customer getCustomerByName(@PathVariable("name")String name) {
		Map<String, Customer> customers = customerRepository.get();
		if(customers.containsKey(name))
			return customers.get(name);
		else
			throw new ResourceNotFoundException(String.format("Customer with name '%s' not found", name));
	}

}
