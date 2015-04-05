package org.twinra.store.domain.repositories;

import org.springframework.stereotype.Service;
import org.twinra.store.domain.Item;
import org.twinra.store.domain.Order;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OrderRepository {

	@Resource
	private ItemRepository itemRepo;

	@Resource
	private CustomerRepository customerRepo;

	private Map<Integer, Order> orders = new HashMap<>();

	@PostConstruct
	private void init() {
		List<Order> ordersList = new ArrayList<>();

		HashMap<Item, Integer> orderContents = new HashMap<>();
		orderContents.put(itemRepo.get().get("Hat"), 2);
		ordersList.add(new Order(1, customerRepo.get().get("Petya"), orderContents));

		for(Order order : ordersList)
			orders.put(order.getId(), order);
	}

	public Map<Integer, Order> get() {
		return orders;
	}
}
