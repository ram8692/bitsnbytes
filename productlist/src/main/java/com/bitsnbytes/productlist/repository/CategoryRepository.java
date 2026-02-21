package com.bitsnbytes.productlist.repository;

import com.bitsnbytes.productlist.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*
 * OVERALL PURPOSE:
 * The Repository is our translator and bridge between our Java code and the actual Database.
 * 
 * WHY AN INTERFACE AND NOT A CLASS?
 * We don't have to write the complex SQL (Database language) queries ourselves! 
 * Spring Boot is smart. By creating an interface that "extends" (inherits from) JpaRepository, 
 * Spring Boot sees this and automatically generates an implementation class behind the scenes for us. 
 * This auto-generated class will contain methods to save(), findById(), findAll(), and delete() categories!
 */

// @Repository tells Spring Boot: "This interface handles database operations. Please manage it."
@Repository
// JpaRepository<Category, Long> tells the framework two things:
// 1. We are storing the 'Category' entity.
// 2. The data type of the Primary Key (ID) of Category is 'Long'.
public interface CategoryRepository extends JpaRepository<Category, Long> {

    // We can leave this completely empty!
    // Spring Boot provides all the basic database saving/reading logic
    // automatically.
    // We would only write code here if we needed a highly specific, custom database
    // query (like finding a category by its name).
}
