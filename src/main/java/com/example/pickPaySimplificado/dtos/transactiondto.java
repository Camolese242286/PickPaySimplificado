package com.example.pickPaySimplificado.dtos;

import java.math.BigDecimal;

public record transactiondto(BigDecimal value ,Long senderId, Long receiverId) {

}
