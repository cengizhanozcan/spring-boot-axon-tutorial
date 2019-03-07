package com.ceng.tutorial.eventsourcingaxon.category.command;

import com.ceng.tutorial.eventsourcingaxon.base.BaseCommand;
import com.ceng.tutorial.eventsourcingaxon.category.event.UpdateCategoryEvent;
import com.ceng.tutorial.eventsourcingaxon.category.model.Category;
import com.ceng.tutorial.eventsourcingaxon.category.model.CategoryStatus;

import java.util.UUID;

public class UpdateCategoryCommand extends BaseCommand<String> {

    public final Long categoryId;
    public final String name;
    public final CategoryStatus categoryStatus;

    public UpdateCategoryCommand(Category category) {
        super(UUID.randomUUID().toString());
        this.categoryId = category.getId();
        this.name = category.getName();
        this.categoryStatus = category.getCategoryStatus();
    }

    public UpdateCategoryEvent toUpdateCategoryEvent() {
        return new UpdateCategoryEvent(this.id, this.categoryId, this.name, this.categoryStatus);
    }
}
