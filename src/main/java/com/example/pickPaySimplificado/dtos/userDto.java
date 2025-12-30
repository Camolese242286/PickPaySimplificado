package com.example.pickPaySimplificado.dtos;

import java.math.BigDecimal;

import com.example.pickPaySimplificado.domain.userType;

public record userDto(String firstName,String lastName,String document,BigDecimal balance,String email,String password,userType userType) {

}
