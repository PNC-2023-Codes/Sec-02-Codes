package com.douglashdezt.library.services;

import java.util.List;

import com.douglashdezt.library.models.dtos.SaveBookDTO;
import com.douglashdezt.library.models.entities.Book;
import com.douglashdezt.library.models.entities.Category;

public interface BookService {
	void save(SaveBookDTO info, Category category) throws Exception;
	void deleteById(String id) throws Exception;
	
	List<Book> findAll();
	List<Book> findAllByIsbn(String isbn);
	
	Book findById(String id);
}
