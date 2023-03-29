package com.douglashdezt.sec02.library.models.dtos;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class ErrorsFieldDTO {
	private String field;
	private List<String> messages;
	
	public ErrorsFieldDTO(String field) {
		super();
		this.field = field;
		this.messages = new ArrayList<>();
	}
	
	
}
