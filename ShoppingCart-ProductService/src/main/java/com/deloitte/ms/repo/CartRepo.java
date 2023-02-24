package com.deloitte.ms.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.deloitte.ms.model.Cart;


@Repository
public interface CartRepo extends JpaRepository<Cart, String> {
	@Query(value = "select * from cart where cname=:cname", nativeQuery = true)
	public List<Cart> getCartItemsByUsername(String cname); 
}
