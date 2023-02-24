package com.deloitte.ms.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.deloitte.ms.model.Product;


@Repository
public interface ProductRepo extends JpaRepository<Product, String>{
	@Query(value = "select * from product p where p.productid=:productid", nativeQuery = true)
	public Product getProductsBasedOnId(int productid);
}
