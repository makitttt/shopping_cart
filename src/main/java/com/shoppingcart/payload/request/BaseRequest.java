package com.shoppingcart.payload.request;

import java.io.Serializable;

public abstract class BaseRequest implements Serializable {

	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public BaseRequest(String id) {
		this.id = id;
	}

	public BaseRequest() {

	}
}
