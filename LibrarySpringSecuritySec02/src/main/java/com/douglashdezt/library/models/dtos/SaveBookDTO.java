package com.douglashdezt.library.models.dtos;

import java.util.Date;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class SaveBookDTO {
	@NotEmpty 
	@Pattern(regexp = "^(?:ISBN(?:-10)?:? )?(?=[0-9X]{10}$|(?=(?:[0-9]+[- ]){3})[- 0-9X]{13}$)[0-9]{1,5}[- ]?[0-9]+[- ]?[0-9]+[- ]?[0-9X]$")
	private String isbn;
	
	@NotEmpty
	private String title;
	
	@NotEmpty
	private Date publishDate;
	
	@NotEmpty
	@Pattern(regexp = "^[0-9A-Z]{4}$")
	private String category;
}
