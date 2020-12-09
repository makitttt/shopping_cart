package com.shoppingcart.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.shoppingcart.models.Product;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {
	List<Product> findAll();

	Product findByName(String name);

	Product findProductById(String id);
}
