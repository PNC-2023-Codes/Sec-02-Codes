package com.douglashdezt.sec02.library.models.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
public class SaveBookDTO {
	
	@NotEmpty(message = "ISBN Vacio!")
	@Size(min = 10, max = 10, message = "El ISBN debe tener 10 caracteres")
	private String isbn;
	
	@NotEmpty(message = "Título vacío")
	private String title;
	
	@NotEmpty(message = "Correo vacío")
	@Email(message = "Se necesita un correo válido")
	private String owner;
	
	
	
	
	
	
	
}
