package com.ceng.tutorial.eventsourcingaxon.category.command;

import com.ceng.tutorial.eventsourcingaxon.base.BaseCommand;
import com.ceng.tutorial.eventsourcingaxon.category.event.CreateCategoryEvent;
import com.ceng.tutorial.eventsourcingaxon.category.model.Category;
import com.ceng.tutorial.eventsourcingaxon.category.model.CategoryStatus;

import java.util.UUID;

public class CreateCategoryCommand extends BaseCommand<String> {

    public final Long categoryId;
    public final String name;
    public final CategoryStatus categoryStatus;

    public CreateCategoryCommand(Category category) {
        super(UUID.randomUUID().toString());
        this.categoryId = category.getId();
        this.name = category.getName();
        this.categoryStatus = category.getCategoryStatus();
    }

    public CreateCategoryEvent toCreateCategoryEvent() {
        return new CreateCategoryEvent(this.id, this.categoryId, this.name, this.categoryStatus);
    }
}
