package com.example.pickPaySimplificado.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.pickPaySimplificado.domain.user;
import com.example.pickPaySimplificado.dtos.NotificationDto;

@Service
public class NotificationService {

	@Autowired
	private RestTemplate restTemplate;
	
	public void sendeNotification(user user, String message) throws Exception {
		
		String email= user.getEmail();
		
		
		NotificationDto notificationRequest= new NotificationDto(email , message);
		
	   ResponseEntity<String>notificationResponse=restTemplate.postForEntity("http://o48d9z.mocklab.io/notify", notificationRequest, String.class);
	
	
	if(!(notificationResponse.getStatusCode()== HttpStatus.OK)) {
		
		
		System.out.println("Erro ao enviar notificação");
		throw new Exception("Serviço de notificação não disponivel");
		
	}
	
	
	}
}
