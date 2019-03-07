package com.ceng.tutorial.eventsourcingaxon.category.service;

import com.ceng.tutorial.eventsourcingaxon.category.model.Category;
import com.ceng.tutorial.eventsourcingaxon.category.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public void saveOrUpdate(Category category) {
        categoryRepository.save(category);
    }

    public void delete(Category category) {
        categoryRepository.delete(category);
    }
}
