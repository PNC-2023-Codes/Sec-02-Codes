package com.douglashdezt.libraryREST.services;

import com.douglashdezt.libraryREST.models.dtos.RegisterDTO;
import com.douglashdezt.libraryREST.models.entities.User;

public interface UserService {
	/*
	 * Register, findOneById 
	 */
	//TODO login
	
	void register(RegisterDTO info);
	User findOneById(String identifier);
}
