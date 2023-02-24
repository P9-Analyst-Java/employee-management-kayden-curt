package com.deloitte.ms.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "customer")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class LoginUser {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String username;
	private String password;
	private String name;
	private String email;
	
	public List<GrantedAuthority> getAuthorities() {
		return List.of(()->"read");
	}
	
}
