package com.shoppingcart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootShoopingCartApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootShoopingCartApplication.class, args);
		
		// if we want to add data here we can use user and product repositories
	}

}
