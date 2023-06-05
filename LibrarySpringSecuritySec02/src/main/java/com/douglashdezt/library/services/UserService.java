package com.douglashdezt.library.services;

import com.douglashdezt.library.models.dtos.RegisterUserDTO;
import com.douglashdezt.library.models.entities.User;

public interface UserService {

	void register(RegisterUserDTO info) throws Exception;
	User findOneByIdentifer(String identifier);
	User findOneByIdentifer(String username, String email);
	Boolean comparePassword(String toCompare, String current);
	
}
