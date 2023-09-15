package com.zayar.practice.service;

import org.springframework.stereotype.Service;

import com.zayar.practice.api.model.RegistrationBody;
import com.zayar.practice.exception.UserAlreadyExistsException;
import com.zayar.practice.model.LocalUser;
import com.zayar.practice.model.dao.LocalUserDAO;

import jakarta.validation.Valid;

@Service
public class UserService {
	
	private LocalUserDAO localUserDao;
	
	public UserService(LocalUserDAO localUserDAO) {
		this.localUserDao=localUserDAO;
	}

	public LocalUser registerUser( RegistrationBody registrationBody) throws UserAlreadyExistsException{
		
		if(localUserDao.findByEmailIgnoreCase(registrationBody.getEmail()).isPresent()
				|| localUserDao.findByUsernameIgnoreCase(registrationBody.getUsername()).isPresent()) {
			throw new UserAlreadyExistsException();
		}
		
		LocalUser user = new LocalUser();
		user.setFirstName(registrationBody.getFirstName());
		user.setLastName(registrationBody.getLastName());
		user.setEmail(registrationBody.getEmail());
		user.setUsername(registrationBody.getUsername());
		// TO DO : Encrypt the Passwords
		
		user.setPassword(registrationBody.getPassword());
		
		return localUserDao.save(user);
		
		
		
	}
}
