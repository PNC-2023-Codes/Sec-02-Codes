package com.douglashdezt.library.models.dtos;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RegisterUserDTO {

	@NotEmpty
	private String username;
	
	@NotEmpty
	private String email;
	
	@NotEmpty
	@Size(min = 8, max = 32)
	private String password;
	
}
