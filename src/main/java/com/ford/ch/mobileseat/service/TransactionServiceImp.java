package com.ford.ch.mobileseat.service;

import com.ford.ch.mobileseat.model.Transaction;
import com.ford.ch.mobileseat.repository.TransactionsRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
public class TransactionServiceImp extends TransactionService
{

	@Autowired
	private TransactionsRepository transactionsRepository;

	@Override
	public Transaction add(Transaction transaction) {
		return transactionsRepository.save(transaction);
	}
}
