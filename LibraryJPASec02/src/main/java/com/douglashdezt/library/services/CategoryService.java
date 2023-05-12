package com.douglashdezt.library.services;

import java.util.List;

import com.douglashdezt.library.models.dtos.SaveCategoryDTO;
import com.douglashdezt.library.models.entities.Category;

public interface CategoryService {
	void save(SaveCategoryDTO info) throws Exception;
	void deleteOneById(String code) throws Exception;
	List<Category> findAll();
	Category findOneById(String code);
}
