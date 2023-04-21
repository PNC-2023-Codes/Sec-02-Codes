package com.douglashdezt.libraryREST.models.dtos;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SearchBookDTO {
	@NotEmpty(message = "ISBN required")
	@Size(min = 10, max = 10, message= "ISBN must have 10 chars")
	private String isbn;
	
	@NotEmpty(message = "Identifer required")
	private String identifier;
}
