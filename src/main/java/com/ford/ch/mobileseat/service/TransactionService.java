package com.ford.ch.mobileseat.service;

import com.ford.ch.mobileseat.model.Transaction;

public abstract class TransactionService implements MainService<Transaction>
{
    public abstract Transaction add(Transaction transaction);
}
