package com.ford.ch.buycheap.service;

import com.ford.ch.buycheap.model.TransactionTypes;

public abstract class TransactionTypeService implements MainService<TransactionTypes>
{
    public abstract TransactionTypes add(TransactionTypes transaction);
    public abstract TransactionTypes getById(Integer transTypeId);
}
