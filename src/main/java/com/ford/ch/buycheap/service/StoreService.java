package com.ford.ch.buycheap.service;

import com.ford.ch.buycheap.model.Stores;

import java.util.List;

public abstract class StoreService {
    public abstract  List<Stores> getStoresForChosenOutletAndRadius(Integer outletId, Integer radius );
}
