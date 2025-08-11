package com.aaslin.crud.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.aaslin.crud.model.Product;

@Service
public class ProductService {
	private Map<Long,Product> productMap=new HashMap<>();
	public Product addProduct(Product product) {
		productMap.put(product.getId(), product);
		return product;
	}
	public List<Product> getAllProducts(){
		return new ArrayList<>(productMap.values());
	}
	
	 public Product getProductById(Long id) {
		 return productMap.get(id);
	 }
	 
	 public Product updateProducts(Long id,Product updatedProduct) {
		 if(productMap.containsKey(id)) {
			 updatedProduct.setId(id);
			 productMap.put(id, updatedProduct);
			 return updatedProduct;
		 }
		 return null;
	 }
	 
	 public Boolean deleteProduct(Long id) {
		 return productMap.remove(id)!=null;
	 }
}
