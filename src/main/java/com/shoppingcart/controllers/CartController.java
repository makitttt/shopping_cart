package com.shoppingcart.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shoppingcart.models.Cart;
import com.shoppingcart.payload.request.CartRequest;
import com.shoppingcart.security.services.CartService;

@RestController
@RequestMapping("/api/v1/cart")
public class CartController {

	private CartService cartService;

	private static final Logger logger = LoggerFactory.getLogger(CartController.class);

	@Autowired
	public CartController(CartService cartService) {
		this.cartService = cartService;
	}

	@PostMapping(value = "/create")
	public ResponseEntity create(@RequestBody CartRequest cartRequest) {
		try {
			Cart cart = cartService.saveOrUpdate(cartRequest);
			return new ResponseEntity<>(cart, HttpStatus.CREATED);
		} catch (Exception e) {
			System.out.println("Create Cart method error " + e.getMessage());
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping(value = "/cartbyUserid")
	public ResponseEntity getCartByUserId(@RequestBody CartRequest cartRequest) {
		try {
			Cart cart = cartService.findCartByUserId(cartRequest);
			return new ResponseEntity<>(cart, HttpStatus.OK);
		} catch (Exception e) {
			System.out.println("Find Cart by User id method error " + e.getMessage());
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping(value = "/carts")
	public ResponseEntity getCarts() {
		try {
			List<Cart> carts = cartService.findAllCarts();
			return new ResponseEntity<>(carts, HttpStatus.OK);
		} catch (Exception e) {
			System.out.println("Find Cart by User id method error" + e.getMessage());
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
