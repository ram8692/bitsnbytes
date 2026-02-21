package com.bitsnbytes.productlist.service;

import org.springframework.stereotype.Service;

/*
 * OVERALL PURPOSE:
 * The Product Service is the "Kitchen Manager" for all Product-related logic.
 * 
 * WHAT WOULD GO HERE?
 * Currently it's empty, but if someone tried to "Create a Product", the Controller would pass the ProductDTO here.
 * This file would:
 * 1. Read the category_id from the ProductDTO.
 * 2. Talk to the CategoryRepository to actually go find that Category in the database.
 * 3. Talk to the ProductMapper to combine the DTO + the real Category into a combined Product Entity.
 * 4. Talk to the ProductRepository to finally save the new Product into the database.
 * 
 * WHY NOT DO THIS IN THE CONTROLLER?
 * Because that involves complicated steps! The Controller just wants to say "Here is a package from the internet, tell me when it's saved."
 */
@Service
public class ProductService {

    // Future business logic goes here:
    // inject ProductRepository
    // inject CategoryRepository
    // create product, get all products, update product, delete product etc.
}
