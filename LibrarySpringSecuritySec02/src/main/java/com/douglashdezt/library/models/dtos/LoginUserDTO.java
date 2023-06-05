package com.douglashdezt.library.models.dtos;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class LoginUserDTO {

	@NotEmpty
	private String identifier;
	
	@NotEmpty
	private String password;
	
}
