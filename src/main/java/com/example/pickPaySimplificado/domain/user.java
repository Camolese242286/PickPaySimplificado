package com.example.pickPaySimplificado.domain;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity(name="users")
@Table(name="users")
@Data
@AllArgsConstructor
@EqualsAndHashCode(of="id")
public class user {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	
	
	private String firstName;
	
	private String lastName;
	
	@Column(unique = true)
	private String documento;
	
	@Column (unique = true)
	private String email;
	
	private String password;
	
	private BigDecimal balance;
	
	@Enumerated(EnumType.STRING)
	private userType userType;
	
	
	
	

	
	
}
