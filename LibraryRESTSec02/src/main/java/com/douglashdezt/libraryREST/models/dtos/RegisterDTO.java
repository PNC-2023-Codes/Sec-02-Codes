package com.douglashdezt.libraryREST.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RegisterDTO {
	private String username;
	private String email;
	private String password;
}
