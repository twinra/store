package org.twinra.store;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.twinra.store.domain.Customer;
import org.twinra.store.domain.Item;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@ComponentScan
@RestController
@EnableAutoConfiguration
public class StoreController {

	@Resource
	private Storage storage;

	@RequestMapping("/customers")
	public List<Customer> getCustomers() {
		return new ArrayList<>(storage.getCustomers().values());
	}

	@RequestMapping("/items")
	public List<Item> getItems() {
		return new ArrayList<>(storage.getItems().values());
	}

	@RequestMapping("/customer/{name}")
	public ResponseEntity<Customer> getCustomerByName(@PathVariable("name")String name) throws NotFoundException {
		Map<String, Customer> customers = storage.getCustomers();
		if(customers.containsKey(name))
			return new ResponseEntity<>(customers.get(name), HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	public static void main(String[] args) {
		SpringApplication.run(StoreController.class, args);
	}
}
