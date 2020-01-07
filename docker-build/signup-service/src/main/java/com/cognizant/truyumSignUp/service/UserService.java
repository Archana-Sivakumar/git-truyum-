package com.cognizant.truyumSignUp.service;

import org.springframework.stereotype.Service;

import com.cognizant.truyumSignUp.exception.UserAlreadyExistsException;
import com.cognizant.truyumSignUp.model.Users;

@Service
public interface UserService {

	Users getAllUser(int id);

	public void signUp(Users user) throws UserAlreadyExistsException;
}
