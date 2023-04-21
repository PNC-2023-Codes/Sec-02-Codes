package com.douglashdezt.libraryREST.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.douglashdezt.libraryREST.models.dtos.BookUserResponseDTO;
import com.douglashdezt.libraryREST.models.dtos.SearchBookDTO;
import com.douglashdezt.libraryREST.models.entities.Book;
import com.douglashdezt.libraryREST.models.entities.User;
import com.douglashdezt.libraryREST.services.BookService;
import com.douglashdezt.libraryREST.services.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/library")
@CrossOrigin("*")
public class LibraryController {
	@Autowired
	private UserService userService;
	
	@Autowired
	private BookService bookService;
	
	@GetMapping("/book")
	public ResponseEntity<?> findOneBookByIsbnAndUser(
			@Valid SearchBookDTO search, BindingResult validations){
		if(validations.hasErrors()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		//TODO Validar todo
		User userFound = userService.findOneById(search.getIdentifier());
		if(userFound == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		Book bookFound = bookService.findOneById(search.getIsbn());
		if(bookFound == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		BookUserResponseDTO response = 
				new BookUserResponseDTO(bookFound, userFound);
		
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	
	
	
	
	
	
	
	
	
}
