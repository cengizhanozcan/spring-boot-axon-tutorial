package com.ceng.tutorial.eventsourcingaxon.category.controller;

import com.ceng.tutorial.eventsourcingaxon.category.command.CreateCategoryCommand;
import com.ceng.tutorial.eventsourcingaxon.category.command.DeleteCategoryCommand;
import com.ceng.tutorial.eventsourcingaxon.category.command.UpdateCategoryCommand;
import com.ceng.tutorial.eventsourcingaxon.category.model.Category;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/v1/category")
public class CategoryController {

    @Autowired
    private CommandGateway commandGateway;

    @PostMapping("/")
    public CompletableFuture<String> save(@RequestBody Category category) {
        return commandGateway.send(new CreateCategoryCommand(category));
    }

    @PutMapping("/")
    public CompletableFuture<String> update(@RequestBody Category category) {
        return commandGateway.send(new UpdateCategoryCommand(category));
    }

    @DeleteMapping("/")
    public CompletableFuture<String> delete(@RequestParam Long id) {
        return commandGateway.send(new DeleteCategoryCommand(id));
    }

}
