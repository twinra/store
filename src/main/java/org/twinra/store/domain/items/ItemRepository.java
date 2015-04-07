package org.twinra.store.domain.items;

import org.springframework.stereotype.Service;
import org.twinra.store.domain.items.Item;

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
		itemList.add(Item.builder().name("Hummer").description("heavy, simple and reliable").price(3).build());
		itemList.add(Item.builder().name("Flashlight").description("pocket edition").price(10).build());
		itemList.add(Item.builder().name("Hat").description("fashionable and modern, girls like it").price(50).build());

		for(Item itm : itemList)
			items.put(itm.getName(), itm);
	}

	public Map<String, Item> get() {
		return items;
	}

}
