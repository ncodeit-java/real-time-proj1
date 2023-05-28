package com.ncodeit.inventory.service;

import java.util.List;

import com.ncodeit.inventory.exception.ProductAlreadyExistsException;
import com.ncodeit.inventory.model.Product;

public interface ProductService {
	
	public List<Product> getAllProducts();
	public List<Product> getProductsByCategory(String categoryName);
	public boolean addProduct(Product productDetails) throws ProductAlreadyExistsException;
	public boolean updateProduct(Product productDetails,String productId);
	public boolean deleteProduct(String productId);
}
