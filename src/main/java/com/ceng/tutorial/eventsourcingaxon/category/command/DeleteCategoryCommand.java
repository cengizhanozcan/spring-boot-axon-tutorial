package com.ceng.tutorial.eventsourcingaxon.category.command;

import com.ceng.tutorial.eventsourcingaxon.base.BaseCommand;
import com.ceng.tutorial.eventsourcingaxon.category.event.DeleteCategoryEvent;

import java.util.UUID;

public class DeleteCategoryCommand extends BaseCommand<String> {

    public final Long categoryId;

    public DeleteCategoryCommand(Long categoryId) {
        super(UUID.randomUUID().toString());
        this.categoryId = categoryId;
    }

    public DeleteCategoryEvent toDeleteCategoryEvent() {
        return new DeleteCategoryEvent(this.id, this.categoryId);
    }
}
