package org.twinra.store.domain;

public class Item {
	private String name;
	private String description;
	private int price;

	public Item() {
	}

	public Item(String name, String description, int price) {
		this.name = name;
		this.description = description;
		this.price = price;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Item item = (Item) o;
		return name.equals(item.name);
	}

	@Override
	public int hashCode() {
		return name.hashCode();
	}
}
