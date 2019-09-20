package com.ford.ch.buycheap.service;

import com.ford.ch.buycheap.model.UserPreferences;
import com.ford.ch.buycheap.repository.TransactionsRepository;
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
	public UserPreferences add(UserPreferences transaction) {
		return transactionsRepository.save(transaction);
	}
}
