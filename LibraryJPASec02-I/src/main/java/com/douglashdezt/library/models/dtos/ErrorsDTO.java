package com.douglashdezt.library.models.dtos;

import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorsDTO {
	private Map<String, List<String>> errors;
}
