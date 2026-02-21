package com.bitsnbytes.productlist.dto;

import com.bitsnbytes.productlist.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/*
 * OVERALL PURPOSE:
 * DTO stands for "Data Transfer Object". 
 * 
 * WHY DO WE NEED THIS WHEN WE ALREADY HAVE THE CATEGORY ENTITY?
 * The Entity class (Category) is strictly for talking to our Database. Sometimes, we have sensitive data 
 * in our Database (like passwords, internal IDs, or complex recursive loops) that we do NOT want to send to the user's screen (the frontend).
 * Or, if we change our database structure, we don't want the frontend to immediately crash.
 * 
 * So, we create a DTO. It is a "safe box". We take data from the Database Entity, pack only what we want to share 
 * into this DTO, and send the DTO over the internet.
 */

// @Data is a Lombok superpower that automatically gives us getters, setters, toString(), and other helpful methods.
@Data
// @AllArgsConstructor creates a constructor that takes all variables as
// arguments (id, name, products) at once.
@AllArgsConstructor
// @NoArgsConstructor creates a blank constructor with no arguments. Frameworks
// often need this to create empty objects before filling them.
@NoArgsConstructor
public class CategoryDTO {

    // The unique ID we will share with the frontend
    private Long id;

    // The name we will share
    private String name;

    // A list of ProductDTOs (not standard Products Entity) to ensure we only share
    // safe product data as well!
    private List<ProductDTO> products;

}
