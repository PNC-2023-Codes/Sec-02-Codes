package com.douglashdezt.libraryREST.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
	private String username;
	private String email; 
	private String name;
	
	@JsonIgnore
	private String password;
}
