package com.douglashdezt.sec02.library.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.validation.FieldError;

import com.douglashdezt.sec02.library.models.dtos.ErrorsFieldDTO;

@Component
public class ErrorHandlers {

	public Map<String, ErrorsFieldDTO> mapErrors(List<FieldError> errors) {
    	Map<String, ErrorsFieldDTO> errorsMap = new HashMap<>();
    	
    	errors.stream()
    		.forEach(error -> {
    			//Logica para separar los campos y agruparlos
    			ErrorsFieldDTO data = errorsMap.get(error.getField()+"_errors");
    			if(data == null) {
    				data = new ErrorsFieldDTO(error.getField());
    			}
    			
    			data.getMessages().add(error.getDefaultMessage());
    			errorsMap.put(error.getField()+"_errors", data);
    		});
    	
    	return errorsMap; 
	}
}
