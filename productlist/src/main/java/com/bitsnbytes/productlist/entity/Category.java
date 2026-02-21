package com.bitsnbytes.productlist.entity;

// We import these specific tools (annotations and classes) provided by Jakarta Persistence (JPA) 
// and Lombok so we can use their special features in our class.
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/*
 * OVERALL PURPOSE:
 * This is an "Entity" class. In object-oriented programming, this class represents a real-world thing—a Category.
 * However, because we need to save categories into a database permanently, we use a framework called Hibernate (implemented via JPA).
 * 
 * WHY NOT JUST A NORMAL CLASS?
 * A normal Java class loses its data when the program stops running. By marking this as an @Entity, 
 * we tell the framework: "Please create a table named 'category' in the database, and map the variables in this class to columns in that table."
 */

// @Entity tells the Java program that objects of this class should be stored in a database table.
@Entity
// @Getter and @Setter are from a tool called Lombok. Instead of manually typing
// out "public String getName() { return name; }"
// for every variable, Lombok automatically creates those methods behind the
// scenes. This keeps our code clean and easy to read.
@Getter
@Setter
public class Category {

    /*
     * WHY WE NEED AN ID:
     * Every row in a database table needs a unique identifier (like a student ID
     * number) so we can specifically
     * find, update, or delete it without affecting other rows.
     */

    // @Id marks the 'id' variable as the Primary Key (the unique identifier) in the
    // database table.
    @Id
    // @GeneratedValue tells the database to automatically generate a new, unique
    // number for us every time we save a new Category.
    // Usually, it just counts up: 1, 2, 3, etc. We don't have to manually figure
    // out the next available number.
    // GenerationType.IDENTITY indicates that the persistence provider must assign
    // primary keys for the entity using a database identity column.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // This is simply the name of the category (e.g., "Electronics", "Books").
    // In the database, this will automatically become a column named 'name' that
    // stores text.
    private String name;

    /*
     * UNDERSTANDING RELATIONSHIPS:
     * A single Category can have many Products inside it (like the "Electronics"
     * category has laptops, phones, etc.).
     * We use a List to store many items in Java.
     * 
     * @OneToMany explains this relationship to the database: ONE Category is linked
     * TO MANY Products.
     * mappedBy = "category" tells the database:
     * "Look at the 'category' variable inside the Product class to understand how we are linked."
     * cascade = CascadeType.ALL means:
     * "If I delete this Category, go ahead and automatically delete all Products inside it so we don't have orphaned data."
     */
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<Product> products = new ArrayList<>();

}
