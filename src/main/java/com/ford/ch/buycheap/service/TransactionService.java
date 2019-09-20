package com.ford.ch.buycheap.service;

import com.ford.ch.buycheap.model.UserPreferences;

public abstract class TransactionService implements MainService<UserPreferences>
{
    public abstract UserPreferences add(UserPreferences transaction);
}
