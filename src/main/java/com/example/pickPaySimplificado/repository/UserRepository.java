package com.example.pickPaySimplificado.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pickPaySimplificado.domain.user;

public interface UserRepository extends JpaRepository<user, Long>{

	Optional<user> findUserBydocument(String document);
	
	Optional<user> findUserByid(Long id);
	
	
}
