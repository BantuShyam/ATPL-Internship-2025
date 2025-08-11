package com.aaslin.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aaslin.crud.model.Product;
import com.aaslin.crud.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductService productService;

	public ProductController(ProductService productService) {
		super();
		this.productService = productService;
	}
	
	
	@PostMapping
	public Product addProduct(@RequestBody Product product) {
		return productService.addProduct(product);
	}
	 
//	@GetMapping
//	public List<Product> getProducts(){
//	return productService.getAllProducts();
//    }
	
	
	@GetMapping("/{id}")
	public Product getProductsbyId(@PathVariable Long id){
	return productService.getProductById(id);
    }
	
	@PutMapping("/{id}")
	public Product updateProducts(@PathVariable Long id,@RequestBody Product product){
	return productService.updateProducts(id,product);
    }

	@DeleteMapping("/{id}")
	public String deleteProduct(@PathVariable Long id){
	return productService.deleteProduct(id) ? "product deleted successfully":"product not found";
    }
	
	
}