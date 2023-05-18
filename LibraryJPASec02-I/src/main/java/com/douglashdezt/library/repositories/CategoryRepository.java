package com.douglashdezt.library.repositories;

import java.util.List;

import org.springframework.data.repository.ListCrudRepository;

import com.douglashdezt.library.models.entities.Category;

public interface CategoryRepository 
	extends ListCrudRepository<Category, String>{
	
}
