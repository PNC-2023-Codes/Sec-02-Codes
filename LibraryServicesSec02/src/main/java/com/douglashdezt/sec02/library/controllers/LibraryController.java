package com.douglashdezt.sec02.library.controllers;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.douglashdezt.sec02.library.models.dtos.ErrorsFieldDTO;
import com.douglashdezt.sec02.library.models.dtos.SaveBookDTO;
import com.douglashdezt.sec02.library.models.entites.Book;
import com.douglashdezt.sec02.library.services.BookService;
import com.douglashdezt.sec02.library.utils.ErrorHandlers;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/library")
public class LibraryController {
    
    @Autowired
    private BookService bookService;
    
    @Autowired
    private ErrorHandlers handler;
    
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public String getAllBooksPage(Model model) {
    	model.addAttribute("books", bookService.findAll());
    	return "book-list";
    }
    
    @GetMapping("/")
    public String getHome(Model model) {
    	String time = Calendar.getInstance().getTime().toString();
    	model.addAttribute("time", time);
    	
    	return "main";
    }
    
    @PostMapping("/save")
    public String saveBook(
    		@ModelAttribute @Valid SaveBookDTO bookInfo, 
    		BindingResult result,
    		Model model
    ) {
    	
    	if(result.hasErrors()) {
    		//Manejar esos errores
    		//Devolver un estado de error
    		
    		model.addAttribute("hasErrors", true);
    		model.addAllAttributes(
    				handler.mapErrors(result.getFieldErrors())
    			);
    		
    		return "main";
    	}
    	
    	Book newBook = new Book(bookInfo.getIsbn(), bookInfo.getTitle());
    	bookService.save(newBook);
    	
    	return "redirect:/library/";
    }
    
    
    
    
    
	
}
