package com.example.pickPaySimplificado.services;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.pickPaySimplificado.domain.Transaction;
import com.example.pickPaySimplificado.domain.user;
import com.example.pickPaySimplificado.dtos.Transactiondto;

import com.example.pickPaySimplificado.repository.TransactionsRepository;

@Service
public class TransactionService {

	@Autowired
	private userService userService;
	
	@Autowired
	private TransactionsRepository transacionalRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	
	
	@Autowired
	private NotificationService notificationService;
	
	
	public Transaction creatTransaction(Transactiondto  transaction ) throws Exception {
		user sender =this.userService.findUserById(transaction.senderId());
		
		user reciever= this.userService.findUserById(transaction.receiverId());
		
		userService.validateTransaction(sender, transaction.value());
		
		
		boolean IsAutorized=this.authorizeTransaction(sender, transaction.value()); 
		
		if(!IsAutorized) {
			throw new Exception("transação não autorizada");
		}
		
		Transaction Newtransaction =new Transaction();
		Newtransaction.setAmount(transaction.value());
		Newtransaction.setSender(sender);
		Newtransaction.setReceiver(reciever);
		Newtransaction.setTimestamp(LocalDateTime.now());
		
		sender.setBalance(sender.getBalance().subtract(transaction.value()));
		
		reciever.setBalance(reciever.getBalance().add(transaction.value()));
		
		
		this.transacionalRepository.save(Newtransaction);
		this.userService.saveUser(sender);
		this.userService.saveUser(reciever);
		
		this.notificationService.sendeNotification(sender ,"transação realizada com sucesso");
		this.notificationService.sendeNotification(reciever ,"transação recibida com sucesso");
		
		return Newtransaction; 
	}
	
	public boolean authorizeTransaction(user sender,BigDecimal value) {
		ResponseEntity<Map> authorizationResponse = restTemplate.getForEntity("http://run.mocky.io/v3/8fafdd68-a090-496f-8c9a-3442cf30dae6\r\n"
				+ "",Map.class);
	
	
	
	if(authorizationResponse.getStatusCode()==HttpStatus.OK ) {
		
		String message= (String) authorizationResponse.getBody().get("message");
		
		
		return "Autorizado".equalsIgnoreCase(message);
	}else return false;
	
	
	}
	
	
}
