package com.douglashdezt.library.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.douglashdezt.library.models.dtos.RegisterUserDTO;
import com.douglashdezt.library.models.entities.User;
import com.douglashdezt.library.repositories.UserRepository;
import com.douglashdezt.library.services.UserService;

import jakarta.transaction.Transactional;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	@Transactional(rollbackOn = Exception.class)
	public void register(RegisterUserDTO info) throws Exception {
		User user = new User();
		
		user.setUsername(info.getUsername());
		user.setEmail(info.getEmail());
		
		user.setPassword(passwordEncoder.encode(info.getPassword()));
		
		userRepository.save(user);
	}

	@Override
	public User findOneByIdentifer(String identifier) {
		return userRepository.findOneByUsernameOrEmail(identifier, identifier);
	}

	@Override
	public User findOneByIdentifer(String username, String email) {
		return userRepository.findOneByUsernameOrEmail(username, email);
	}

	@Override
	public Boolean comparePassword(String toCompare, String current) {
		return passwordEncoder.matches(toCompare, current);
	}

}
