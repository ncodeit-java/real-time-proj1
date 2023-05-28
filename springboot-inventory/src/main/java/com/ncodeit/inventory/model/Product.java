package com.ncodeit.inventory.model;

import io.swagger.v3.oas.annotations.media.Schema;

public class Product {
	
	@Schema(description = "Product Id")
	private String productId;
	
	@Schema(description = "Product Name")
	private String productName;
	
	@Schema(description = "Product Description")
	private String productDescription;
	
	@Schema(description = "Product Category")
	private String productCategory;
	
	@Schema(description = "Units")
	private int units;
	
	
	public Product() {
		super();
	}


	public Product(String productId, String productName, String productDescription, String productCategory, int units) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productDescription = productDescription;
		this.productCategory = productCategory;
		this.units = units;
	}


	public String getProductId() {
		return productId;
	}


	public void setProductId(String productId) {
		this.productId = productId;
	}


	public String getProductName() {
		return productName;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}


	public String getProductDescription() {
		return productDescription;
	}


	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}


	public String getProductCategory() {
		return productCategory;
	}


	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}


	public int getUnits() {
		return units;
	}


	public void setUnits(int units) {
		this.units = units;
	}


	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productDescription="
				+ productDescription + ", productCategory=" + productCategory + ", units=" + units + "]";
	}
	
	
	
}
