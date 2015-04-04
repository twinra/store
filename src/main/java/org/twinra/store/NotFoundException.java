package org.twinra.store;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends Exception {
	private String id;

	public String getId() {
		return id;
	}

	public NotFoundException(String id) {
		this.id = id;
	}
}
