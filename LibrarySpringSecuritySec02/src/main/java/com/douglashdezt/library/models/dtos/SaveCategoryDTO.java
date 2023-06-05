package com.douglashdezt.library.models.dtos;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class SaveCategoryDTO {
	
	@NotEmpty(message = "Code is required")
	@Pattern(regexp = "^[A-Z0-9]{4}$", message = "Code must have exactly 4 uppercase alphanumeric chars")
	private String code;
	
	@NotEmpty(message = "Name is required")
	@Size(min = 5, message = "Name must have at least 5 chars")
	private String name;
}
