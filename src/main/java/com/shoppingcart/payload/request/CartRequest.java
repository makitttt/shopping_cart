package com.shoppingcart.payload.request;

import java.util.List;

import com.shoppingcart.models.Product;

public class CartRequest extends BaseRequest {

	private String userId;
	private List<Product> products;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public CartRequest(String id, String UserId, List<Product> products) {
		super(id);
		this.userId = UserId;
		this.products = products;
	}

	public CartRequest() {

	}

}
