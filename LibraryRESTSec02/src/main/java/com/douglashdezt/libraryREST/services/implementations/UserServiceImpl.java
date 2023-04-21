package com.douglashdezt.libraryREST.services.implementations;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

import com.douglashdezt.libraryREST.models.dtos.RegisterDTO;
import com.douglashdezt.libraryREST.models.entities.User;
import com.douglashdezt.libraryREST.services.UserService;

@Service
public class UserServiceImpl implements UserService{
	private static List<User> users = new ArrayList<>();
	
	static {
		users.add(new User("douglashdezt", "dohernandez@uca.edu.sv", "Douglas Hernandez", "12345678Aa!"));
		users.add(new User("naldana", "naldana@uca.edu.sv", "Néstor Aldana", "12345678Aa!"));
		users.add(new User("ecalderon", "ealdana@uca.edu.sv", "Elisa Aldana", "12345678Aa!"));
		users.add(new User("enxel", "earaujo@uca.edu.sv", "Enmanuel Amaya", "12345678Aa!"));
		users.add(new User("evarela", "evarela@uca.edu.sv", "Erick Varela", "12345678Aa!"));
		users.add(new User("armandoCodigos", "rcanizales@uca.edu.sv", "Ronaldo Canizales", "12345678Aa!"));
	}

	@Override
	public void register(RegisterDTO info) {
		// TODO Encrypt Password
		User newUser = new User(
					info.getUsername(),
					info.getEmail(), 
					"",
					info.getPassword() + "_encriptado"
				);
		
		users = Stream.concat(users.stream(), Stream.of(newUser))
					.collect(Collectors.toList());
				
	}

	@Override
	public User findOneById(String identifier) {
		return users.stream()
				.filter(u -> (u.getUsername().equals(identifier) || u.getEmail().equals(identifier)))
				.findAny()
				.orElse(null);
	}
}
