package com.ceng.tutorial.eventsourcingaxon.category.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * The type Category.
 */
@Data
@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
public class Category implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", length = 36, unique = true, nullable = false)
    private Long id;

    @Column(name = "name", length = 200, unique = true, nullable = false)
    private String name;

    @Enumerated
    @Column(name = "status", nullable = false)
    private CategoryStatus categoryStatus;

}
