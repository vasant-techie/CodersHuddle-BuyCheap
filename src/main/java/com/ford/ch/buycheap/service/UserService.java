package com.ford.ch.buycheap.service;


import com.ford.ch.buycheap.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public abstract class UserService implements MainService<User>
{
	//public abstract List<User> getBooksById(int id );

    public abstract Page<User> getAll(Pageable pageable );
    public abstract User add(User user);
    public abstract User getById(String cdsid);
    public abstract User deleteById(String cdsid);
    public abstract User update(User user, String cdsid);
}
