package com.shoppingcart.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.NonNull;

@Document(collection = "products")
public class Product {

    @Id
    private String id;
    private String name;
    private Double value;
    private Integer quantity;

    public Product() {
        this.quantity = 1;
    }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Product(String id, @NonNull String name, @NonNull Double value, Integer quantity) {
		super();
		this.id = id;
		this.name = name;
		this.value = value;
		this.quantity = quantity;
	}
    
	
    
}
