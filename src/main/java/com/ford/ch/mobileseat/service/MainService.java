package com.ford.ch.mobileseat.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MainService<T>
{
	Page<T> getAll(Pageable pageable);

	T add(T o);

	T update(T o, String id);

	T getById(String id);

	T deleteById(String id);
}

