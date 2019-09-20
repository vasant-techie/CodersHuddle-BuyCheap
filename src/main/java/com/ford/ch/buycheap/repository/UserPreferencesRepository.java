package com.ford.ch.buycheap.repository;

import com.ford.ch.buycheap.model.UserPreferences;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserPreferencesRepository extends JpaRepository<UserPreferences, String>
{

}
