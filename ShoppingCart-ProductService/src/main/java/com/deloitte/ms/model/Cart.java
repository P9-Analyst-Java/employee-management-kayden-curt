package com.deloitte.ms.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cart")
@Data
public class Cart {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cartid")
	private int cartid;
	@Column(name="cname")
	private String cname;
	@Column(name = "stock")
	private int stock;
	@Column(name = "category")
	private String category;
	@Column(name = "productname")
	private String productname;
	@Column(name = "price")
	private double price;
	
	
	
}
