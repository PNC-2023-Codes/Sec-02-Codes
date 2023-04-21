package com.douglashdezt.libraryREST.services.implementations;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

import com.douglashdezt.libraryREST.models.entities.Book;
import com.douglashdezt.libraryREST.services.BookService;

@Service
public class BookServiceImpl implements BookService{
	private static List<Book> library = new ArrayList<>();
    private static DateFormat date = new SimpleDateFormat("dd/MM/yyyy");
	
    static {
        try {
			library.add(new Book("0261102303", "Lord of the Rings", date.parse("01/01/1975"), "https://loremflickr.com/1600/2560"));
			library.add(new Book("0007441428", "Game of Thrones", date.parse("01/01/1999"), "https://loremflickr.com/1600/2560"));
	        library.add(new Book("0747581088", "Harry Potter and the Half-Blood Prince", date.parse("01/01/2007"), "https://loremflickr.com/1600/2560"));
	        library.add(new Book("1401248195", "Watchmen", date.parse("01/01/1970"), "https://loremflickr.com/1600/2560"));
	        library.add(new Book("030788743X", "Ready player one", date.parse("01/01/2010"), "https://loremflickr.com/1600/2560"));
	        library.add(new Book("843760494X", "Cien Años de Soledad", date.parse("01/01/1982"), "https://loremflickr.com/1600/2560"));
	        library.add(new Book("0553804367", "A Briefer History of Time", date.parse("01/01/1990"), "https://loremflickr.com/1600/2560"));
        } catch (ParseException e) {
			e.printStackTrace();
		}
    }

	@Override
	public void save(Book book) {
		Stream<Book> filteredBooks = 
				library.stream()
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
	public Book findOneById(String isbn) {
		return library.stream()
					.filter(b -> b.getIsbn().equals(isbn))
					.findAny()
					.orElse(null);
	}

	@Override
	public List<Book> findAll() {
		return library;
	}
}
