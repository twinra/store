package org.twinra.store.domain.customers;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customer {
	private String name;
	private String contacts;
}
