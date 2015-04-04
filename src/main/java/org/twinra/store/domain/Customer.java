package org.twinra.store.domain;

public class Customer {
	private String name;
	private String contacts;

	public Customer() {

	}

	public Customer(String name, String contacts) {
		this.name = name;
		this.contacts = contacts;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContacts() {
		return contacts;
	}

	public void setContacts(String contacts) {
		this.contacts = contacts;
	}
}
