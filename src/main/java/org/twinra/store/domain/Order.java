package org.twinra.store.domain;

import java.util.Map;

public class Order {
	private Integer id;
	private Customer customer;
	private Map<Item, Integer> contents; //item name - quantity

	public Order() {
	}

	public Order(Integer id, Customer customer, Map<Item, Integer> contents) {
		this.id = id;
		this.customer = customer;
		this.contents = contents;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Map<Item, Integer> getContents() {
		return contents;
	}

	public void setContents(Map<Item, Integer> contents) {
		this.contents = contents;
	}
}
