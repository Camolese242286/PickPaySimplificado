package com.example.pickPaySimplificado.dtos;

import java.math.BigDecimal;

public record Transactiondto(BigDecimal value ,Long senderId, Long receiverId) {

}
