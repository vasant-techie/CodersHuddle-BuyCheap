package com.ford.ch.buycheap.controller;

import com.ford.ch.buycheap.model.Stores;
import com.ford.ch.buycheap.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Validated
@RestController
@RequestMapping("/api/v1/stores")
public class StoreController {

    @Autowired
    private StoreService storeService;

    @GetMapping(value = "/{outletId}/{radius}", produces = "application/json")
    public List<Stores> getStoresWithDealsWithinRadius(Integer outletId, Integer radius )
    {
        return storeService.getStoresForChosenOutletAndRadius( outletId, radius);
    }
}
