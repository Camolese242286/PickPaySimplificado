package com.example.pickPaySimplificado.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity(name="transactions")
@Table(name="transactions")
@Data
@AllArgsConstructor
@EqualsAndHashCode(of="id")
public class Transaction {

	public Transaction() {
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	
	private BigDecimal amount;
	
	@ManyToOne
	@JoinColumn(name="sender_id")
	private user sender;
	
	@ManyToOne
	@JoinColumn(name="receiver_id")
	private user receiver;
	
	private LocalDateTime timestamp;
	
	
}
