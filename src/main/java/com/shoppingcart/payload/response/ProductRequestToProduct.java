package com.shoppingcart.payload.response;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.shoppingcart.models.Product;
import com.shoppingcart.payload.request.ProductRequest;

@Component
public class ProductRequestToProduct implements Converter<ProductRequest, Product> {

    @Override
    public Product convert(ProductRequest productRequest) {
        Product product = new Product();
        if (!StringUtils.isEmpty(productRequest.getId())) {
            product.setId(productRequest.getId());
        }
        product.setName(productRequest.getName());
        product.setValue(productRequest.getValue());
        product.setQuantity(productRequest.getQuantity());
        return product;
    }
}
