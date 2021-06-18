package in.stack.productApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.stack.productApp.model.Product;
import in.stack.productApp.repository.ProductRepository;

@Service
public class ProductService { 
	
    @Autowired
	private ProductRepository repo;
    
    public boolean addProduct(Product p) {
    	
    	return repo.addProduct(p);
    }
    
      public boolean deleteProduct(int productId) {
    	
    	return repo.deleteProduct(productId);
    		
    	}

      public List<Product> getAllProducts(){
    	  return repo.getAllProducts();
      }
   

}
