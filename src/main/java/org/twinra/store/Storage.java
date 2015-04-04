package org.twinra.store;

import org.springframework.stereotype.Service;
import org.twinra.store.domain.Customer;
import org.twinra.store.domain.Item;
import org.twinra.store.domain.Order;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class Storage {
	//TODO: hibernate it

	private Map<String, Item> items;
	private Map<String, Customer> customers;
	private Map<Integer, Order> orders;

	public Storage() {
		this.items = new HashMap<>();
		this.customers = new HashMap<>();
		this.orders = new HashMap<>();

		List<Item> items = new ArrayList<>();
		items.add(new Item("Hummer", "heavy, simple and reliable", 3));
		items.add(new Item("Phone", "antique one", 20));
		items.add(new Item("Hat", "fashionable and modern, girls like it", 50));
		for(Item itm : items)
			this.items.put(itm.getName(), itm);

		List<Customer> customers = new ArrayList<>();
		customers.add(new Customer("Vasya", "vk.com: vasyok11"));
		customers.add(new Customer("Masha", "phone: +7(926)123-45-67"));
		customers.add(new Customer("Petya", "email: just@petya.org"));
		for(Customer c: customers)
			this.customers.put(c.getName(), c);
	}

	public Map<String, Item> getItems() {
		return items;
	}

	public Map<String, Customer> getCustomers() {
		return customers;
	}

	public Map<Integer, Order> getOrders() {
		return orders;
	}
}
