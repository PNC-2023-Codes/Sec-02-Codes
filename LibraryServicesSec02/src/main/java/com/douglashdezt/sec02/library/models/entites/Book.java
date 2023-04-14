package com.douglashdezt.sec02.library.models.entites;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
public class Book {
	private String isbn;
	private String title;
}
