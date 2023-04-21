package com.douglashdezt.libraryREST.models.entities;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Book {
	private String isbn;
	private String title;
	private Date publishDate;
	private String image;
}
