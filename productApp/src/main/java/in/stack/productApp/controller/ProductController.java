package in.stack.productApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import in.stack.productApp.model.Product;
import in.stack.productApp.service.ProductService;

@Controller
public class ProductController {
	
	@Autowired
	private ProductService service;
	
	@GetMapping("/addProduct")
	public String showProductForm() {
		return "product-form";
	}

	
	@PostMapping("/addProduct")
	public String AddNewProduct(@RequestParam("name")String pname,
			@RequestParam("price") double price,@RequestParam("quantity")int quantity) {
		String response=null;
		Product newProduct=new Product(pname,price,quantity);
	if(	service.addProduct(newProduct)) {
		response="redirect:/allProducts";
		
	}else {
		response="redirect:/addProduct";
	}
		
		return response;
	}
	
	
	// Show All Products
	@GetMapping("/allProducts")
	public String showAllProducts(Model model) {
		
		model.addAttribute("products",service.getAllProducts());
		return "allProducts";
		
	}
	
	
	
	
	
}
