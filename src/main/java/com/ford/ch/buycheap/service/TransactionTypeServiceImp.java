package com.ford.ch.buycheap.service;

import com.ford.ch.buycheap.exception.ResourceNotFoundException;
import com.ford.ch.buycheap.model.TransactionTypes;
import com.ford.ch.buycheap.repository.TransactionTypeRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
public class TransactionTypeServiceImp extends TransactionTypeService
{

	@Autowired
	private TransactionTypeRepository transactionTypeRepository;

	@Override
	public TransactionTypes add(TransactionTypes transactionType) {
		return transactionTypeRepository.save(transactionType);
	}

	public TransactionTypes getById(Integer transTypeId)
	{
		return checkIfIdIsPresentandReturnTransType( transTypeId );
	}

	private TransactionTypes checkIfIdIsPresentandReturnTransType(Integer transTypeId)
	{
		if ( !transactionTypeRepository.findById( transTypeId ).isPresent() )
			throw new ResourceNotFoundException( " Transaction Type id = " + transTypeId + " not found" );
		else
			return transactionTypeRepository.findById( transTypeId ).get();
	}
}
