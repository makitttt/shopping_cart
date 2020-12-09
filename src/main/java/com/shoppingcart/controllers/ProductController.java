package com.shoppingcart.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shoppingcart.models.Product;
import com.shoppingcart.payload.request.ProductRequest;
import com.shoppingcart.security.services.ProductService;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

	private ProductService productService;

	@Autowired
	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	@GetMapping("/products")
	public ResponseEntity products() {
		try {
			List<Product> products = productService.findAll();
			return new ResponseEntity<>(products, HttpStatus.OK);
		} catch (Exception e) {
			System.out.println("Find products method error " + e.getMessage());
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/productByName/{name}")
	public ResponseEntity getproductByName(@PathVariable(value = "name") String name) {
		try {
			Product product = productService.findByName(name);
			return new ResponseEntity<>(product, HttpStatus.OK);
		} catch (Exception e) {
			System.out.println("Find product by Name method error " + e.getMessage());
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/productbyid/{id}")
	public ResponseEntity getproductById(@PathVariable(value = "id") String id) {
		try {
			Product product = productService.findProductById(id);
			return new ResponseEntity<>(product, HttpStatus.OK);
		} catch (Exception e) {
			System.out.println("Find product by Id method error " + e.getMessage());
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping(value = "/create")
	public ResponseEntity create(@RequestBody ProductRequest productRequest) {
		try {
			Product product = productService.saveOrUpdate(productRequest);
			return new ResponseEntity<>(product, HttpStatus.CREATED);
		} catch (Exception e) {
			System.out.println("Create product method error " + e.getMessage());
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping(value = "/update")
	public ResponseEntity update(@RequestBody ProductRequest productRequest) {
		try {
			Product product = productService.saveOrUpdate(productRequest);
			return new ResponseEntity<>(product, HttpStatus.OK);
		} catch (Exception e) {
			System.out.println("Update product method error " + e.getMessage());
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity delete(@PathVariable(value = "id") String id) {
		try {
			productService.delete(id);
			return new ResponseEntity<>("Success to remove product!", HttpStatus.OK);
		} catch (Exception e) {
			System.out.println("Erro no delete " + e.getMessage());
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
