package com.douglashdezt.sec02.library.controllers;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import jakarta.validation.Valid;

@Controller
@RequestMapping("/library")
public class LibraryController {
	
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
    
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public String getAllBooksPage(Model model) {
    	model.addAttribute("books", library);
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
    	System.out.println(bookInfo);
    	
    	List<FieldError> errors = result.getFieldErrors();
    	Map<String, ErrorsFieldDTO> errorsMap = new HashMap<>();
    	
    	errors.stream()
    		.forEach(error -> {
    			//Logica para separar los campos y agruparlos
    			ErrorsFieldDTO data = errorsMap.get(error.getField()+"_errors");
    			if(data == null) {
    				data = new ErrorsFieldDTO(error.getField());
    			}
    			
    			data.getMessages().add(error.getDefaultMessage());
    			errorsMap.put(error.getField()+"_errors", data);
    		});
    	
    	
    	
    	if(result.hasErrors()) {
    		//Manejar esos errores
    		//Devolver un estado de error
    		
    		model.addAttribute("hasErrors", true);
    		model.addAllAttributes(errorsMap);
    		return "main";
    	}
    	
    	Book newBook = new Book(bookInfo.getIsbn(), bookInfo.getTitle());
    	library.add(newBook);
    	
    	return "redirect:/library/";
    }
    
    
    
    
    
	
}
