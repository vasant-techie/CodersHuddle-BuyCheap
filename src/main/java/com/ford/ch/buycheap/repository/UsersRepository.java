package com.ford.ch.buycheap.repository;

import com.ford.ch.buycheap.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<User, String>
{

}
