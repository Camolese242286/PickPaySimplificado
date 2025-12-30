package com.example.pickPaySimplificado.cotrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pickPaySimplificado.domain.user;
import com.example.pickPaySimplificado.dtos.userDto;
import com.example.pickPaySimplificado.services.userService;

@RestController
@RequestMapping("/user")
public class UsersController {

	@Autowired
	private userService userService;
	
	@PostMapping
	public ResponseEntity<user> creatUser(@RequestBody userDto user){
		
		user newUser= userService.creatUser(user); 
		
		
		return new ResponseEntity<>(newUser,HttpStatus.CREATED);
		
	}


	@GetMapping
	public ResponseEntity<List<user>> getAllUsers(){
		
		
		List<user> users=this.userService.getAllUsers();
		
		return new ResponseEntity<>(users ,HttpStatus.OK);
	}

}
