package com.deloitte.ms.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.deloitte.ms.entity.LoginUser;

@Repository
public interface LoginUserRepo extends JpaRepository<LoginUser, Long>{
	Boolean existsByEmail(String email);
	Optional<LoginUser>findByEmail(String email);
}
