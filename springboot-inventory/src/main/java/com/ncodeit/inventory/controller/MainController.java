package com.ncodeit.inventory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.ncodeit.inventory.exception.ProductAlreadyExistsException;
import com.ncodeit.inventory.model.Product;
import com.ncodeit.inventory.service.ProductService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/airbusManagement")

//swagger doc
@SecurityRequirement(name = "Bearer")
@Tag(name = "Inventory", description = "Endpoints for managing inventory system")
public class MainController {
	
	@Autowired
	ProductService productService;
	
	ObjectMapper objectMapper = new ObjectMapper().configure(SerializationFeature.INDENT_OUTPUT, true);
	
	@GetMapping("/getAllProducts")
	@Operation(description = "Get All Products")
	@Parameters(value= {
			@Parameter(name="Authorization",in = ParameterIn.HEADER,required = true,description = "JWT Bearer Token",schema = @Schema(type = "string"))
	})
	@ApiResponses(value = {
			@ApiResponse(responseCode ="200",content = {@Content(mediaType = "application/json",schema = @Schema(implementation = Object.class))})
	})
	public Object getAllProducts(){
		List<Product> result= productService.getAllProducts();
		return result;
	}
	
	@GetMapping("/getProductsByCategory/{key}")
	@Operation(description = "Get Products By Category")
	@Parameters(value= {
			@Parameter(name="Authorization",in = ParameterIn.HEADER,required = true,description = "JWT Bearer Token",schema = @Schema(type = "string"))
	})
	@ApiResponses(value = {
			@ApiResponse(responseCode ="200",content = {@Content(mediaType = "application/json",schema = @Schema(implementation = Object.class))})
	})
	public Object getProductsByCategory(@PathVariable("key") String categoryName) throws JsonProcessingException{
		
		List<Product> result= productService.getProductsByCategory(categoryName);
		String listToJson = objectMapper.writeValueAsString(result);
		return listToJson;
	}

	@PostMapping("/addProduct")
	@Operation(description = "Add Product")
	@Parameters(value= {
			@Parameter(name="Authorization",in = ParameterIn.HEADER,required = true,description = "JWT Bearer Token",schema = @Schema(type = "string"))
	})
	@ApiResponses(value = {
			@ApiResponse(responseCode ="200",content = {@Content(mediaType = "application/json",schema = @Schema(implementation = Boolean.class))})
	})
	public boolean addProduct(@RequestBody Product producDetails) throws JsonProcessingException, ProductAlreadyExistsException{
		
		boolean response = productService.addProduct(producDetails);
		return response;
	}
	
	@PostMapping("updateProduct/{productId}") 
	@Operation(description = "Update Product")
	@Parameters(value= {
			@Parameter(name="Authorization",in = ParameterIn.HEADER,required = true,description = "JWT Bearer Token",schema = @Schema(type = "string"))
	})
	@ApiResponses(value = {
			@ApiResponse(responseCode ="200",content = {@Content(mediaType = "application/json",schema = @Schema(implementation = Object.class))})
	})	
    public boolean updateProduct(@RequestBody Product productDetails,@PathVariable("productId") String productId) {  
        boolean result= productService.updateProduct(productDetails, productId);  
        return result;  
    }  
	
	@DeleteMapping("deleteProduct/{productId}")
	@Operation(description = "Delete Product")
	@Parameters(value= {
			@Parameter(name="Authorization",in = ParameterIn.HEADER,required = true,description = "JWT Bearer Token",schema = @Schema(type = "string"))
	})
	@ApiResponses(value = {
			@ApiResponse(responseCode ="200",content = {@Content(mediaType = "application/json",schema = @Schema(implementation = Object.class))})
	})	
    public boolean deleteProduct(@PathVariable("productId") String productId) {  
        boolean result= productService.deleteProduct(productId);  
        return result;  
    } 
	
}
