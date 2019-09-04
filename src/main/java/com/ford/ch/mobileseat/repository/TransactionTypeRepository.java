package com.ford.ch.mobileseat.repository;

import com.ford.ch.mobileseat.model.Transaction;
import com.ford.ch.mobileseat.model.TransactionTypes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionTypeRepository extends JpaRepository<TransactionTypes, Integer>
{

}
