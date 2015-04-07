package org.twinra.store.domain.items;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.twinra.store.exceptions.ResourceNotFoundException;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class ItemController {

	@Resource
	private ItemRepository itemRepository;

	@RequestMapping("/items")
	public List<Item> getItems() {
		return new ArrayList<>(itemRepository.get().values());
	}

	@RequestMapping("/items/{name}")
	public Item getItemByName(@PathVariable("name")String name) {
		Map<String, Item> items = itemRepository.get();
		if(items.containsKey(name))
			return items.get(name);
		else
			throw new ResourceNotFoundException(String.format("Item with name '%s' not found", name));
	}

}
