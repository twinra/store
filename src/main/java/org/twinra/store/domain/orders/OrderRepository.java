package org.twinra.store.domain.orders;

import org.springframework.stereotype.Service;
import org.twinra.store.domain.customers.CustomerRepository;
import org.twinra.store.domain.items.ItemRepository;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.math.BigDecimal;
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

		Order.Content contentUnit = Order.Content.builder()
			.item(itemRepo.get().get("Hat"))
			.quantity(2)
			.price(new BigDecimal(45))
			.comment("nice price")
			.build();

		ordersList.add(
			Order.builder()
				.id(1)
				.customer(customerRepo.get().get("Petya"))
				.comment("first order")
				.line(Order.Content.builder()
					.item(itemRepo.get().get("Hat"))
					.quantity(2)
					.price(new BigDecimal(45))
					.comment("with discount")
					.build()
				)
				.build()
		);

		for(Order order : ordersList)
			orders.put(order.getId(), order);
	}

	public Map<Integer, Order> get() {
		return orders;
	}
}
