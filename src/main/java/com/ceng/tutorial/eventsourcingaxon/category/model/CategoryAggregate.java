package com.ceng.tutorial.eventsourcingaxon.category.model;

import com.ceng.tutorial.eventsourcingaxon.category.command.CreateCategoryCommand;
import com.ceng.tutorial.eventsourcingaxon.category.command.DeleteCategoryCommand;
import com.ceng.tutorial.eventsourcingaxon.category.command.UpdateCategoryCommand;
import com.ceng.tutorial.eventsourcingaxon.category.event.CreateCategoryEvent;
import lombok.NoArgsConstructor;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
@NoArgsConstructor
public class CategoryAggregate {

    @AggregateIdentifier
    private String id;

    @CommandHandler
    public CategoryAggregate(CreateCategoryCommand createCategoryCommand) {
        AggregateLifecycle.apply(createCategoryCommand.toCreateCategoryEvent());
    }

    @CommandHandler
    public CategoryAggregate(UpdateCategoryCommand updateCategoryCommand) {
        AggregateLifecycle.apply(updateCategoryCommand.toUpdateCategoryEvent());
    }

    @CommandHandler
    public CategoryAggregate(DeleteCategoryCommand deleteCategoryCommand) {
        AggregateLifecycle.apply(deleteCategoryCommand.toDeleteCategoryEvent());
    }

    @EventSourcingHandler
    public void createCategoryEventHandler(CreateCategoryEvent createCategoryEvent) {
        this.id = createCategoryEvent.id;
    }

    @EventSourcingHandler
    public void updateCategoryEventHandler(UpdateCategoryCommand updateCategoryCommand) {
        this.id = updateCategoryCommand.id;
    }

    @EventSourcingHandler
    public void deleteCategoryEventHandler(DeleteCategoryCommand deleteCategoryCommand) {
        this.id = deleteCategoryCommand.id;
    }

}
