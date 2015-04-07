package org.twinra.store.domain.orders;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.twinra.store.exceptions.ResourceNotFoundException;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class OrderController {

	@Resource
	private OrderRepository orderRepository;


	@RequestMapping("/orders")
	public List<Order> getOrders() {
		return new ArrayList<>(orderRepository.get().values());
	}

	@RequestMapping("/orders/{id}")
	public Order getOrderById(@PathVariable("id")Integer id) {
		Map<Integer, Order> orders = orderRepository.get();
		if(orders.containsKey(id))
			return orders.get(id);
		else
			throw new ResourceNotFoundException(String.format("Order with id '%s' not found", id));
	}
}
