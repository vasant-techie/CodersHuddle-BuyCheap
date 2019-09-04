package com.ford.ch.mobileseat.repository;

import com.ford.ch.mobileseat.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionsRepository extends JpaRepository<User, Integer>
{

}
