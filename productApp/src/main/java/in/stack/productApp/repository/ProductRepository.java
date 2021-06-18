package in.stack.productApp.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import in.stack.productApp.model.Product;



@Repository
@Transactional
public class ProductRepository {
	
	@Autowired
	private SessionFactory sf;
	
	private Session getCurrentSession() {
		return sf.getCurrentSession();
		
	}
	
	// CRUD API methods
	
	
	//Save A New Product to Hibernate
	public boolean addProduct(Product p) {
		boolean status=false;
		if(getCurrentSession().save(p)!=null) {
			status=true;
		}
		
		return status;	
	}
	
	// Get All Products As a List
	public List<Product> getAllProducts(){
		
		List <Product> allProducts=getCurrentSession().createQuery("from Product",Product.class).list();
		
		return allProducts;
	}
	
	// Delete Product based on Product ID
	public boolean deleteProduct(int id) {
		boolean status=false;
		
		Product target=getCurrentSession().find(Product.class,id);
		try {
			if(target!=null) {
		
			getCurrentSession().remove(target);
			status=true;
			
			}
			
		}
		catch(Exception e) {
			status=false;
			e.printStackTrace();
		}
		
		return status;
	}
	

}
