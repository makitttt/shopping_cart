package com.shoppingcart.security.services;

import java.util.List;

import com.shoppingcart.models.Cart;
import com.shoppingcart.payload.request.CartRequest;

public interface CartService {
	Cart saveOrUpdate(CartRequest cartRequest);

	Cart findCartByUserId(CartRequest cartRequest);

	List<Cart> findAllCarts();
}
