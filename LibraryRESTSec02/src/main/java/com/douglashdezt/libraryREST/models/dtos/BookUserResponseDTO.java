package com.douglashdezt.libraryREST.models.dtos;

import com.douglashdezt.libraryREST.models.entities.Book;
import com.douglashdezt.libraryREST.models.entities.User;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BookUserResponseDTO {
	private Book book;
	private User user;
}
