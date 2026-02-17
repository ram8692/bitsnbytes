package com.bitsnbytes.productlist.entity;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

// @Entity marks this class as a persistent Java class (an entity) that represents a table in the database.
@Entity
// Lombok annotations to automatically generate getters and setters for all
// fields, reducing boilerplate code.
@Getter
@Setter
public class Category {

    // @Id specifies the primary key of an entity.
    @Id
    // @GeneratedValue provides for the specification of generation strategies for
    // the values of primary keys.
    // GenerationType.IDENTITY indicates that the persistence provider must assign
    // primary keys for the entity using a database identity column.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // The name of the category. This matches a column in the 'category' table.
    private String name;

    // @OneToMany indicates a one-to-many relationship (one category has many
    // products).
    // mappedBy = "category" tells Hibernate that the 'category' field in the
    // Product class owns the relationship.
    // cascade = CascadeType.ALL means that any change happened on Category object
    // must default cascade to related Product objects.
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<Product> products;

}
