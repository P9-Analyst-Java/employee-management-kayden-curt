package com.deloitte.ms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deloitte.ms.model.Cart;
import com.deloitte.ms.model.Product;
import com.deloitte.ms.repo.CartRepo;
import com.deloitte.ms.repo.ProductRepo;


@RestController
@RequestMapping("/cart")
public class CartController {
	@Autowired
	CartRepo cartRepo;
	
	@Autowired
	ProductRepo productRepo;
	
//	@GetMapping("/getAll")
//	public ResponseEntity<List<Cart>> getAllProduct(){
//		return new ResponseEntity<List<Cart>>(cartRepo.findAll(),HttpStatus.OK);
//	}
	
	@GetMapping("/getByName/{cname}")
	public ResponseEntity<List<Cart>> getcartdetailsbyusername(@PathVariable String cname){
		return new ResponseEntity<List<Cart>>(cartRepo.getCartItemsByUsername(cname),HttpStatus.OK);
	}
	

	@PostMapping("/add/{username}/{id}")
	public ResponseEntity<Cart> addProduct(@PathVariable String username,@PathVariable int id,@RequestBody Cart cart) {
		Product product= productRepo.getProductsBasedOnId(id);
		Cart cart1 = new Cart(cart.getCartid(),username,cart.getStock(),product.getProductCategory(), product.getProductName(), product.getProductPrice());
		return new ResponseEntity<Cart>(cartRepo.save(cart1),HttpStatus.OK);
	
	}
}
