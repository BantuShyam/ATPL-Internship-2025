package com.aaslin.spEL;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Product {
	
	@Value("Laptop")
	private String name;
	
	@Value("67000")
	private double price;
	
	@Value("#{67000 *0.8}")
	private double discountedPrice;
	
	@Value("true")
	private boolean inStock;
	
	@Value("#{true ? 'Product is available' :' not in stock'}")
	private String availabilityMessage;
	
	 public void printDetails() {
	        System.out.println("Product Name: " + name);
	        System.out.println("Price: " + price);
	        System.out.println("Discounted Price: " + discountedPrice);
	        System.out.println("In Stock: " + inStock);
	        System.out.println("Availability: " + availabilityMessage);
	    }
}
