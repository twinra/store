package org.twinra.store;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@EnableAutoConfiguration
public class StoreController {

	public static void main(String[] args) {
		SpringApplication.run(StoreController.class, args);
	}
}
