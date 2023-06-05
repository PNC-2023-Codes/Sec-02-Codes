package com.douglashdezt.library.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;

import com.douglashdezt.library.models.entities.Book;

public interface BookRepository 
	extends ListCrudRepository<Book, UUID>{

	List<Book> findByIsbn(String isbn);
	
}
