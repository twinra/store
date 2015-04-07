package org.twinra.store.domain.items;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Item {
	private String name;
	private String description;
	private int price;
}
