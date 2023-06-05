package com.douglashdezt.library.services.implementations;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.douglashdezt.library.models.dtos.SaveBookDTO;
import com.douglashdezt.library.models.entities.Book;
import com.douglashdezt.library.models.entities.Category;
import com.douglashdezt.library.repositories.BookRepository;
import com.douglashdezt.library.services.BookService;

import jakarta.transaction.Transactional;

@Service
public class BookServiceImpl implements BookService{

	@Autowired
	private BookRepository bookRepository;
	
	@Override
	@Transactional(rollbackOn = Exception.class)
	public void save(SaveBookDTO info, Category category) throws Exception {
		Book book = new Book(
					info.getIsbn(),
					info.getTitle(),
					info.getPublishDate(),
					category
				);
		
		bookRepository.save(book);
	}

	@Override
	@Transactional(rollbackOn = Exception.class)
	public void deleteById(String id) throws Exception {
		UUID code = UUID.fromString(id);
		bookRepository.deleteById(code);
	}

	@Override
	public List<Book> findAll() {
		return bookRepository.findAll();
	}

	@Override
	public List<Book> findAllByIsbn(String isbn) {
		return bookRepository.findByIsbn(isbn);
	}

	@Override
	public Book findById(String id) {
		try {
			UUID code = UUID.fromString(id);
			return bookRepository.findById(code)
					.orElse(null);
		} catch (Exception e) {
			return null;
		}
		
	}

}
