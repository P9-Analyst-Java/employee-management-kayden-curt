package com.deloitte.ms.controller;


import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.deloitte.ms.entity.Cart;

import net.minidev.json.JSONArray;



@RestController
//@RequestMapping("/get")
public class AuthController {
	
	
	@Autowired
	RestTemplate restTemplate;

	@GetMapping("/showProducts")
	public List<Object> getProduct() {
		
		Object response = restTemplate.getForObject("http://localhost:3004/product/getAll", Object.class);
		return Arrays.asList(response);
	}
	
	@PostMapping(value = "/addcartitems/{username}/{id}")
	public Object addCartItems(@RequestBody Cart cart,@PathVariable("username") String username, @PathVariable("id") int id){
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<Cart> request = new HttpEntity<Cart>(cart, headers);
		Object response = restTemplate.exchange("http://localhost:3004/cart/add/{username}/{id}", HttpMethod.POST, request,
				new ParameterizedTypeReference<String>() {
				},username,id).getBody();
		return response;
	}
	
	@GetMapping("/get/cartitems/{cname}")
	public List<Object> getCartItems(@PathVariable String cname) {
		System.out.println(cname);
		Object response = restTemplate.getForObject("http://localhost:3004/cart/getByName/"+cname, Object.class);
		return Arrays.asList(response);
	}
}
