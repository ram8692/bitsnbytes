package com.bitsnbytes.productlist.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

// @Entity marks this class as a persistent Java class (an entity) that represents a table in the database.
@Entity
// @Getter and @Setter are Lombok annotations that generate the getter and
// setter methods for the private fields automatically.
@Getter
@Setter
public class Product {

    // @Id specifies the primary key of an entity.
    @Id
    // @GeneratedValue configures the way of increment of the specified
    // column(field).
    // GenerationType.IDENTITY relies on an auto-incremented database column to
    // generate the primary key.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Field mapped to the 'name' column in the product table.
    private String name;

    // Field mapped to the 'description' column.
    private String description;

    // Field mapped to the 'price' column.
    private Double price;

    // @ManyToOne indicates a many-to-one relationship (many products belong to one
    // category).
    @ManyToOne
    // @JoinColumn is used to specify the foreign key column.
    // name="category_id" specifies the name of the foreign key column in the
    // product table.
    // nullable = false indicates that the foreign key column cannot be null (every
    // product must have a category).
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;
}
