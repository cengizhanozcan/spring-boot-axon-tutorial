package com.ceng.tutorial.eventsourcingaxon.category.event;

import com.ceng.tutorial.eventsourcingaxon.base.BaseEvent;
import com.ceng.tutorial.eventsourcingaxon.category.model.Category;

public class DeleteCategoryEvent extends BaseEvent<String> {

    public final Long categoryId;

    public DeleteCategoryEvent(String id, Long categoryId) {
        super(id);
        this.categoryId = categoryId;
    }

    public Category toCategory() {
        Category category = new Category();
        category.setId(categoryId);

        return category;
    }

}
