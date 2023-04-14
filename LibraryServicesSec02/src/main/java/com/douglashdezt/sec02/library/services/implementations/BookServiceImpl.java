package com.douglashdezt.sec02.library.services.implementations;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

import com.douglashdezt.sec02.library.models.entites.Book;
import com.douglashdezt.sec02.library.services.BookService;

@Service
public class BookServiceImpl implements BookService {

	private static List<Book> library = new ArrayList<>();
    
    static {
        library.add(new Book("0261102303", "Lord of the Rings"));
        library.add(new Book("0007441428", "Game of Thrones v2"));
        library.add(new Book("0747581088", "Harry Potter and the Half-Blood Prince"));
        library.add(new Book("1401248195", "Watchmen"));
        library.add(new Book("030788743X", "Ready player one v2"));
        library.add(new Book("843760494X", "Cien Años de Soledad"));
        library.add(new Book("0553804367", "A Briefer History of Time"));
    }
	
	@Override
	public void save(Book book) {
		Stream<Book> filteredBooks = library.stream()
			.filter(b -> !b.getIsbn().equals(book.getIsbn()));
		
		library = Stream.concat(filteredBooks, Stream.of(book))
			.collect(Collectors.toList());
	}

	@Override
	public void delete(String isbn) {
		library = library.stream()
			.filter(b -> !b.getIsbn().equals(isbn))
			.collect(Collectors.toList());
	}

	@Override
	public List<Book> findAll() {
		return library;
	}

	@Override
	public Book findOneByIsbn(String isbn) {
		Book foundBook = library.stream()
			.filter(b -> b.getIsbn().equals(isbn))
			.findAny()
			.orElse(null);
			
		return foundBook;
	}

	
	
	
	
	
	
	
	
	
}
