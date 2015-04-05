package org.twinra.store.domain.repositories;

import org.springframework.stereotype.Service;
import org.twinra.store.domain.Item;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ItemRepository {

	private Map<String, Item> items = new HashMap<>();

	@PostConstruct
	private void init() {
		List<Item> itemList = new ArrayList<>();
		itemList.add(new Item("Hummer", "heavy, simple and reliable", 3));
		itemList.add(new Item("Phone", "antique one", 20));
		itemList.add(new Item("Hat", "fashionable and modern, girls like it", 50));

		for(Item itm : itemList)
			items.put(itm.getName(), itm);
	}

	public Map<String, Item> get() {
		return items;
	}

}
