package com.ford.ch.buycheap.service;

import com.ford.ch.buycheap.model.Stores;
import com.ford.ch.buycheap.repository.StoresRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@NoArgsConstructor
public class StoreServiceImp extends StoreService {

    @Autowired
    private StoresRepository storeRepository;

    @Override
    public List<Stores> getStoresForChosenOutletAndRadius(Integer outletId, Integer radius) {
        storeRepository.findByOutletAndRadiusAndDiscountNotNull(outletId, radius);
        return null;
    }
}
