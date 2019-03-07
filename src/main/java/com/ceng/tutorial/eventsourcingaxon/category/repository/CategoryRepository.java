package com.ceng.tutorial.eventsourcingaxon.category.repository;

import com.ceng.tutorial.eventsourcingaxon.category.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
