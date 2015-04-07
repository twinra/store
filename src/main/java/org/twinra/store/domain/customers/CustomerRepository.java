package org.twinra.store.domain.customers;

import org.springframework.stereotype.Service;

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
		customerList.add(Customer.builder().name("Vasya").contacts("vk.com: vasyok11").build());
		customerList.add(Customer.builder().name("Masha").contacts("phone: +7(926)123-45-67").build());
		customerList.add(Customer.builder().name("Petya").contacts("email: just@petya.org").build());

		for(Customer itm : customerList)
			customers.put(itm.getName(), itm);
	}

	public Map<String, Customer> get() {
		return customers;
	}

}
