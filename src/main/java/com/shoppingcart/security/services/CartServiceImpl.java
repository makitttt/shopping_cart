package com.shoppingcart.security.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shoppingcart.models.Cart;
import com.shoppingcart.payload.request.CartRequest;
import com.shoppingcart.payload.response.CartRequestToCart;
import com.shoppingcart.repository.CartRepository;

@Service
public class CartServiceImpl implements CartService {

	private CartRepository cartRepository;
	private CartRequestToCart cartRequestToCart;

	@Autowired
	public CartServiceImpl(CartRepository cartRepository, CartRequestToCart cartRequestToCart) {
		this.cartRepository = cartRepository;
		this.cartRequestToCart = cartRequestToCart;
	}

	@Override
	public synchronized Cart saveOrUpdate(CartRequest cartRequest) {
		return cartRepository.save(cartRequestToCart.convert(cartRequest));
	}

	@Override
	public synchronized Cart findCartByUserId(CartRequest cartRequest) {
		return cartRepository.findCartByUserId(cartRequest.getUserId());
	}

	@Override
	public List<Cart> findAllCarts() {
		return cartRepository.findAll();
	}
}
