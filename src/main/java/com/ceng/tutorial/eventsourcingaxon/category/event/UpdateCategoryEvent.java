package com.ceng.tutorial.eventsourcingaxon.category.event;

import com.ceng.tutorial.eventsourcingaxon.base.BaseEvent;
import com.ceng.tutorial.eventsourcingaxon.category.model.Category;
import com.ceng.tutorial.eventsourcingaxon.category.model.CategoryStatus;

public class UpdateCategoryEvent extends BaseEvent<String> {
    public final Long categoryId;
    public final String name;
    public final CategoryStatus categoryStatus;

    public UpdateCategoryEvent(String id, Long categoryId, String name, CategoryStatus categoryStatus) {
        super(id);
        this.categoryId = categoryId;
        this.name = name;
        this.categoryStatus = categoryStatus;
    }

    public Category toCategory() {
        Category category = new Category();
        category.setId(categoryId);
        category.setName(name);
        category.setCategoryStatus(categoryStatus);

        return category;
    }

}
