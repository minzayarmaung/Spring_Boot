package com.zayar.practice.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.zayar.practice.api.model.LoginBody;
import com.zayar.practice.api.model.RegistrationBody;
import com.zayar.practice.exception.UserAlreadyExistsException;
import com.zayar.practice.model.LocalUser;
import com.zayar.practice.model.dao.LocalUserDAO;

@Service
public class UserService {
	
	private LocalUserDAO localUserDao;
	
	private EncryptionService encryptionService;
	
	private JWTService jwtService;
	
	public UserService(LocalUserDAO localUserDAO, EncryptionService encryptionService, JWTService jwtService) {
		this.localUserDao=localUserDAO;
		this.jwtService=jwtService;
		this.encryptionService=encryptionService;
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
		
		user.setPassword(encryptionService.encryptPasssword(registrationBody.getPassword()));
		
		return localUserDao.save(user);
		
	}
	
	public String loginUser(LoginBody loginBody) {
		Optional<LocalUser> opUser = localUserDao.findByUsernameIgnoreCase(loginBody.getUsername());
		if(opUser.isPresent()) {
			LocalUser user = opUser.get();
			
			if(encryptionService.verifyPassword(loginBody.getPassword(), user.getPassword())) {
				return jwtService.generateJWT(user); 
			}
		}
		return null;
	}
}
