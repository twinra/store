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
import org.twinra.store.domain.Order;
import org.twinra.store.domain.repositories.CustomerRepository;
import org.twinra.store.domain.repositories.ItemRepository;
import org.twinra.store.domain.repositories.OrderRepository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@ComponentScan
@RestController
@EnableAutoConfiguration
public class StoreController {

	@Resource
	private ItemRepository itemRepository;

	@Resource
	private CustomerRepository customerRepository;

	@Resource
	private OrderRepository orderRepository;


	@RequestMapping("/customers")
	public List<Customer> getCustomers() {
		return new ArrayList<>(customerRepository.get().values());
	}

	@RequestMapping("/customer/{name}")
	public ResponseEntity<Customer> getCustomerByName(@PathVariable("name")String name) {
		Map<String, Customer> customers = customerRepository.get();
		if(customers.containsKey(name))
			return new ResponseEntity<>(customers.get(name), HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}


	@RequestMapping("/items")
	public List<Item> getItems() {
		return new ArrayList<>(itemRepository.get().values());
	}

	@RequestMapping("/item/{name}")
	public ResponseEntity<Item> getItemByName(@PathVariable("name")String name) {
		Map<String, Item> items = itemRepository.get();
		if(items.containsKey(name))
			return new ResponseEntity<>(items.get(name), HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}


	@RequestMapping("/orders")
	public List<Order> getOrders() {
		return new ArrayList<>(orderRepository.get().values());
	}

	@RequestMapping("/order/{id}")
	public ResponseEntity<Order> getOrderById(@PathVariable("id")String id) {
		Map<Integer, Order> orders = orderRepository.get();
		if(orders.containsKey(id))
			return new ResponseEntity<>(orders.get(id), HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	public static void main(String[] args) {
		SpringApplication.run(StoreController.class, args);
	}
}
