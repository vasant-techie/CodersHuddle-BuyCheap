package com.ford.ch.mobileseat.service;

import com.ford.ch.mobileseat.model.TransactionTypes;

public abstract class TransactionTypeService implements MainService<TransactionTypes>
{
    public abstract TransactionTypes add(TransactionTypes transaction);
    public abstract TransactionTypes getById(Integer transTypeId);
}
