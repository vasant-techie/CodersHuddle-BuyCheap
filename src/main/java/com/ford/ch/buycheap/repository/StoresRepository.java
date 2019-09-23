package com.ford.ch.buycheap.repository;

import com.ford.ch.buycheap.model.Stores;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StoresRepository extends JpaRepository<Stores, String>
{
    public List<Stores> findByOutletAndRadiusAndDiscountNotNull(Integer outletId, Integer radius);
}
