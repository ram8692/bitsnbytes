package com.bitsnbytes.productlist.repository;

import com.bitsnbytes.productlist.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*
 * OVERALL PURPOSE:
 * The Repository is our interface to talk to the 'product' table in the database.
 * 
 * HOW DOES AN EMPTY INTERFACE DO ANYTHING?
 * Because it extends `JpaRepository`, Spring Boot automatically acts as our robot assistant. 
 * As long as we provide `<Product, Long>` (the entity it saves, and the data type of the entity's ID), 
 * the robot automatically gives us pre-written methods to .save(), .findAll(), .deleteById() without us writing a single line of SQL code!
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
