package com.example.pickPaySimplificado.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pickPaySimplificado.domain.Transaction;

public interface TransactionsRepository extends JpaRepository<Transaction, Long> {
	

}
