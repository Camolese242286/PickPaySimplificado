package com.example.pickPaySimplificado.services;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pickPaySimplificado.domain.user;
import com.example.pickPaySimplificado.domain.userType;
import com.example.pickPaySimplificado.repository.UserRepository;

@Service



public class userService {

	
	@Autowired
	private UserRepository repository;
	
	
	public void validateTransaction(user sender,BigDecimal amount) throws Exception {
		
		if(sender.getUserType() == userType.MERCHANT) {
			throw new Exception("usuario do tipo lojista nao tem autorização para fazer transferencia");
		}
		
		
		if(sender.getBalance().compareTo(amount)< 0) {
	
			throw new Exception("saldo insuficiente");
			
		}		
		
		
	}
	
	
	public user findUserById(Long id) throws Exception {
		
	return	this.repository.findById(id).orElseThrow(()-> new Exception("usuario não encotrado"));
	}
	
	public void saveUser(user user) {
		this.repository.save(user);
	}
}
