package com.shoppingcart.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.shoppingcart.models.Cart;

@Repository
public interface CartRepository extends MongoRepository<Cart, String> {
	Cart findCartByUserId(String userId);
}
