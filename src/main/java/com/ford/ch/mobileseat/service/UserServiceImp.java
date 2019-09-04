package com.ford.ch.mobileseat.service;

import com.ford.ch.mobileseat.exception.ResourceNotFoundException;
import com.ford.ch.mobileseat.model.User;
import com.ford.ch.mobileseat.repository.UsersRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
@NoArgsConstructor
public class UserServiceImp extends UserService
{

	@Autowired
	private UsersRepository userRepository;

	public Page<User> getAll(Pageable pageable )
	{
		return userRepository.findAll( pageable );
	}

	public User add(User user)
	{
		return userRepository.save(user);
	}

	public User update( User o, String cdsid )
	{
		User user = checkIfIdIsPresentandReturnUser( cdsid );
		user.setName( o.getName() );
		user.setPassword( o.getPassword() );
		return userRepository.save( user );
	}

	public User getById( String cdsid )
	{
		return checkIfIdIsPresentandReturnUser( cdsid );
	}

	public User deleteById( String cdsid )
	{
		User user = checkIfIdIsPresentandReturnUser( cdsid );
		userRepository.deleteById( cdsid );
		return user;
	}

	private User checkIfIdIsPresentandReturnUser( String cdsid )
	{
		if ( !userRepository.findById( cdsid ).isPresent() )
			throw new ResourceNotFoundException( " User id = " + cdsid + " not found" );
		else
			return userRepository.findById( cdsid ).get();
	}
}
