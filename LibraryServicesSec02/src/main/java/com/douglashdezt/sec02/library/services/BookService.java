package com.douglashdezt.sec02.library.services;

import java.util.List;

import com.douglashdezt.sec02.library.models.entites.Book;

public interface BookService {
	// Save, Delete, FindAll, FindOneIsbn
	
	void save(Book book);
	void delete(String isbn);
	List<Book> findAll();
	Book findOneByIsbn(String isbn);
}
