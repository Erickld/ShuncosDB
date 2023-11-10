package com.gen.shuncosDB.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gen.shuncosDB.model.Product;
import com.gen.shuncosDB.repository.ProductRepository;


@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	//Get all products
	public List<Product> getAllProducts(){
		return productRepository.findAll();
	}
	
	//Get products filter by model
	public List<Product> getProductsByModel(String modelTxt){
		return productRepository.findByModelContaining(modelTxt);
	}


	//Get
	public Product getProductById(Long id){
		return productRepository.findById(id).orElse(null);
	}

	//Post
	public Product createProduct(HashMap<String, Object> productJson) {
		Product product = new Product();

		product.setModel((String)productJson.get("model"));
		product.setImage_url((String)productJson.get("image_url"));
		product.setSleeve_type((String)productJson.get("sleeve_type"));
		product.setGenre((String)productJson.get("genre"));
		product.setIs_adult_size((boolean)productJson.get("is_adult_size"));
		product.setSize_list((String)productJson.get("size_list"));
		product.setColor((String)productJson.get("color"));
		product.setPrice(Double.parseDouble((String)productJson.get("price")));
		
		return productRepository.save(product);
	}
	
	//Put
	public Product updateProduct(Long id, HashMap<String, Object> productJson) {
		Product product = productRepository.findById(id).orElse(null);
		
		product.setModel((String)productJson.get("model"));
		product.setImage_url((String)productJson.get("image_url"));
		product.setSleeve_type((String)productJson.get("sleeve_type"));
		product.setGenre((String)productJson.get("genre"));
		product.setIs_adult_size((boolean)productJson.get("is_adult_size"));
		product.setSize_list((String)productJson.get("size_list"));
		product.setColor((String)productJson.get("color"));
		product.setPrice(Double.parseDouble((String)productJson.get("price")));
		
		return productRepository.save(product);
	}
	
	//Delete
	public void deleteProduct(Long id) {
		productRepository.deleteById(id);
	}
	
	
}
