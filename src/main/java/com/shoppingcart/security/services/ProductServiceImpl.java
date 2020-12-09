package com.shoppingcart.security.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shoppingcart.models.Product;
import com.shoppingcart.payload.request.ProductRequest;
import com.shoppingcart.payload.response.ProductRequestToProduct;
import com.shoppingcart.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;
    private ProductRequestToProduct productRequestToProduct;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, ProductRequestToProduct productRequestToProduct) {
        this.productRepository = productRepository;
        this.productRequestToProduct = productRequestToProduct;
    }

    @Override
    public synchronized List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public synchronized Product saveOrUpdate(ProductRequest productRequest) {
        return productRepository.save(productRequestToProduct.convert(productRequest));
    }

    @Override
    public synchronized void delete(String id) {
        productRepository.deleteById(id);
    }

    @Override
    public synchronized Product findByName(String name) {
        return productRepository.findByName(name);
    }

    @Override
    public synchronized Product findProductById(String id) {
        return productRepository.findProductById(id);
    }
}
