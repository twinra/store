package org.twinra.store.domain.orders;

import lombok.*;
import org.twinra.store.domain.customers.Customer;
import org.twinra.store.domain.items.Item;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Order {
	private Integer id;
	private Customer customer;
	private String comment;
	@Singular
	private List<Content> lines;

	@Getter
	@Setter
	@NoArgsConstructor
	@AllArgsConstructor
	@Builder
	public static class Content {
		private Item item;
		private Integer quantity;
		private BigDecimal price;
		private String comment;
	}
}
