package org.twinra.store.domain.repositories;

import org.springframework.stereotype.Service;
import org.twinra.store.domain.Customer;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CustomerRepository {

	private Map<String, Customer> customers = new HashMap<>();

	@PostConstruct
	private void init() {
		List<Customer> customerList = new ArrayList<>();
		customerList.add(new Customer("Vasya", "vk.com: vasyok11"));
		customerList.add(new Customer("Masha", "phone: +7(926)123-45-67"));
		customerList.add(new Customer("Petya", "email: just@petya.org"));

		for(Customer itm : customerList)
			customers.put(itm.getName(), itm);
	}

	public Map<String, Customer> get() {
		return customers;
	}

}
