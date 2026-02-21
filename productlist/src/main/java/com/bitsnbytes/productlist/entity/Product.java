package com.bitsnbytes.productlist.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/*
 * OVERALL PURPOSE:
 * This Entity class represents a single product (like "Laptop") in our database.
 * 
 * WHY IS THIS AN @Entity?
 * By labeling it @Entity, Hibernate (our database manager) knows to automatically create 
 * a "product" table in our SQL database. Each variable inside this class becomes a column in that table.
 */
@Entity
// @Getter and @Setter are Lombok annotations.
// They automatically write the hidden "getProduct()", "setPrice()" etc. methods
// so we don’t have to.
@Getter
@Setter
public class Product {

    /*
     * The unique database ID (Primary Key) for this product.
     * 
     * @GeneratedValue says
     * "Database, please auto-generate a new number each time I add a new product."
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // The name of the product. This becomes a 'name' text column in the database.
    private String name;

    // A description of what the product does.
    private String description;

    // The cost of the product. Stored as a decimal number (Double).
    private Double price;

    /*
     * UNDERSTANDING RELATIONSHIPS:
     * Are products floating around randomly? No, they belong to a Category.
     * E.g., A "MacBook" belongs to the "Electronics" category.
     * 
     * @ManyToOne tells the database:
     * "Many different products can belong to ONE single category."
     * 
     * @JoinColumn tells the database: "Create a separate relationship column named
     * 'category_id'.
     * This column will store the ID of the category this product belongs to."
     * nullable = false means:
     * "You CANNOT save a product to the database unless you tell me which category it belongs to."
     */
    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;
}
