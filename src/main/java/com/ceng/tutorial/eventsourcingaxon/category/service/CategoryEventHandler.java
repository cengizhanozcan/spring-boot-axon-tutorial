package com.ceng.tutorial.eventsourcingaxon.category.service;

import com.ceng.tutorial.eventsourcingaxon.category.event.CreateCategoryEvent;
import com.ceng.tutorial.eventsourcingaxon.category.event.DeleteCategoryEvent;
import com.ceng.tutorial.eventsourcingaxon.category.event.UpdateCategoryEvent;
import com.ceng.tutorial.eventsourcingaxon.category.model.Category;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryEventHandler {

    @Autowired
    private CategoryService categoryService;

    @EventHandler
    public void on(CreateCategoryEvent createCategoryEvent) {
        Category category = createCategoryEvent.toCategory();
        categoryService.saveOrUpdate(category);
    }

    @EventHandler
    public void on(UpdateCategoryEvent updateCategoryEvent) {
        Category category = updateCategoryEvent.toCategory();
        categoryService.saveOrUpdate(category);
    }

    @EventHandler
    public void on(DeleteCategoryEvent deleteCategoryEvent) {
        Category category = deleteCategoryEvent.toCategory();
        categoryService.delete(category);
    }
}
