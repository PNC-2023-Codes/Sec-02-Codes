package com.douglashdezt.libraryREST.services;

import java.util.List;

import com.douglashdezt.libraryREST.models.entities.Book;

public interface BookService {
	/*
	 * Save, delete, findOneById, findAll
	 */
	
	void save(Book book);
	void delete(String isbn);
	Book findOneById(String isbn);
	List<Book> findAll();
}
