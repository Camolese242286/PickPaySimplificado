package com.example.pickPaySimplificado.cotrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pickPaySimplificado.domain.Transaction;
import com.example.pickPaySimplificado.dtos.Transactiondto;

import com.example.pickPaySimplificado.services.TransactionService;

@RestController
@RequestMapping("/transactions")
public class TrasactionController {

	
	@Autowired
	private TransactionService transactionService;
	
	@PostMapping
	public ResponseEntity<Transaction> creatTransaction(@RequestBody Transactiondto transaction)throws Exception{
		Transaction newTransaction =this.transactionService.creatTransaction(transaction);
		
		return new ResponseEntity<>(newTransaction,HttpStatus.OK);
	}
}
