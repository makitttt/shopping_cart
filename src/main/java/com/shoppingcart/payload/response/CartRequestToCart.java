package com.shoppingcart.payload.response;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.shoppingcart.models.Cart;
import com.shoppingcart.payload.request.CartRequest;

@Component
public class CartRequestToCart implements Converter<CartRequest, Cart> {

    @Override
    public Cart convert(CartRequest cartRequest) {
        Cart cart = new Cart();
        if (!StringUtils.isEmpty(cartRequest.getId())) {
            cart.setId(cartRequest.getId());
        }
        cart.setUserId(cartRequest.getUserId());
        cart.setProducts(cartRequest.getProducts());
        return cart;
    }
}
