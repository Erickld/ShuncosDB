package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Product;
import repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	//Get all products
	public List<Product> getAllProducts(){
		return productRepository.findAll();
	}

	//Get
	public Product getProductById(Long id){
		return productRepository.findById(id).orElse(null);
	}

	//Post
	public Product createProduct(Product product) {
		return productRepository.save(product);
	}
	
	//Put
	public Product updateProduct(Long id, Product productDetails) {
		Product product = productRepository.findById(id).orElse(null);
		
		product.setModel(productDetails.getModel());
		product.setImage_url(productDetails.getImage_url());
		product.setSleeve_type(productDetails.getSleeve_type());
		product.setGenre(productDetails.getGenre());
		product.setIs_adult_size(productDetails.isIs_adult_size());
		product.setSize_list(productDetails.getSize_list());
		product.setColor(productDetails.getColor());
		product.setPrice(productDetails.getPrice());
		
		return productRepository.save(product);
	}
	
	//Delete
	public void deleteProduct(Long id) {
		productRepository.deleteById(id);
	}
	
	
}
