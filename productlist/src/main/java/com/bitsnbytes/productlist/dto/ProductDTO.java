package com.bitsnbytes.productlist.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * OVERALL PURPOSE:
 * ProductDTO is our "safe box" for sending data over the internet.
 * 
 * WHY A DTO?
 * Look at the Product Entity! It has an entire `Category` object inside it. 
 * If we sent the full Product Entity over the internet, it might send the entire Category, 
 * which might send ALL products in that category, sending huge amounts of data and causing an infinite loop! 
 * Instead, here in the DTO, we only send the basic product info and a simple `category_id` number.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {

    // The basic properties of the product that the user needs to see on their
    // screen
    private Long id;
    private String name;
    private String description;
    private Double price;

    // Notice this is just a single Long number, not an entire Category object!
    // This keeps our internet traffic light and prevents infinite loops.
    private Long category_id;
}
