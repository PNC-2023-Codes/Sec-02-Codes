package com.douglashdezt.library.services.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.douglashdezt.library.models.dtos.SaveCategoryDTO;
import com.douglashdezt.library.models.entities.Category;
import com.douglashdezt.library.repositories.CategoryRepository;
import com.douglashdezt.library.services.CategoryService;

import jakarta.transaction.Transactional;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	@Transactional(rollbackOn = Exception.class)
	public void save(SaveCategoryDTO info) throws Exception {
		Category newCategory = new Category(info.getCode(), info.getName());
		categoryRepository.save(newCategory);
	}

	@Override
	@Transactional(rollbackOn = Exception.class)
	public void deleteOneById(String code) throws Exception {
		categoryRepository.deleteById(code);
	}

	@Override
	public List<Category> findAll() {
		return categoryRepository.findAll();
	}

	@Override
	public Category findOneById(String code) {
		return categoryRepository
				.findById(code)
				.orElse(null);
	}
}
