package com.shoppingcart.security.services;

import java.util.List;

import com.shoppingcart.models.Product;
import com.shoppingcart.payload.request.ProductRequest;

public interface ProductService {
    List<Product> findAll();

    Product findByName(String name);

    Product findProductById(String id);

    Product saveOrUpdate(ProductRequest productRequest);

    void delete(String id);
}
