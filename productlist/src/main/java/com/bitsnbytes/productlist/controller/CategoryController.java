package com.bitsnbytes.productlist.controller;

import com.bitsnbytes.productlist.dto.CategoryDTO;
import com.bitsnbytes.productlist.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * OVERALL PURPOSE:
 * The Controller is the "Front Door" or the "Waiter" of our application. 
 * When a user on the internet tries to access our app (like a React frontend, mobile app, or Postman), 
 * their HTTP Request lands exactly here.
 * 
 * It takes the request, hands the data to the Service (Kitchen Manager) to do the real work, 
 * and then formats the final response to send back over the internet.
 * 
 * WHY DO WE SEPARATE THIS?
 * The Controller only cares about HTTP (internet) traffic. It does not know or care how the database works.
 */

// @RestController tells Spring Boot: "This class will handle internet web requests, and it will reply with pure data (JSON format), not an HTML website."
@RestController
// @RequestMapping sets the base URL for this entire class. Meaning, every
// internet request made to "http://our-website.com/api/categories" will be
// directed to this file.
@RequestMapping("/api/categories")
// @AllArgsConstructor automatically creates a constructor to inject our Service
// variable automatically inside, so we don't get a NullPointerException.
@AllArgsConstructor
public class CategoryController {

    // We link our Service so we can pass the data off to execute business logic.
    private CategoryService categoryService;

    /*
     * HOW THE FLOW WORKS for adding a category:
     * 
     * @PostMapping means:
     * "If someone sends an HTTP POST request (which implies they want to CREATE something) to /api/categories, trigger this exact method."
     * 
     * WHY A RESPONSE ENTITY?
     * ResponseEntity allows us to customize the entire HTTP response that goes back
     * to the browser.
     * By default, a success returns a "200 OK" status. But when we CREATE
     * something, the proper web standard is to return "201 CREATED". ResponseEntity
     * lets us do exactly that!
     */
    @PostMapping
    // @RequestBody tells Spring Boot: "Look at the JSON text that the user sent
    // over the internet, and automatically try to build a CategoryDTO object out of
    // it."
    public ResponseEntity<CategoryDTO> createCategory(@RequestBody CategoryDTO categoryDTO) {

        // Step 1: We call our Service to do all the heavy lifting (which includes
        // mapping and saving to DB).
        CategoryDTO savedCategory = categoryService.createCategory(categoryDTO);

        // Step 2: We package the finished data into a neat HTTP response, attach the
        // "201 CREATED" status code, and send it straight back over the internet to the
        // user.
        return new ResponseEntity<>(savedCategory, HttpStatus.CREATED);

    }

    // Future API endpoints will go here (like reading, updating, or deleting data):
    // get all categories
    // get category by id
    // delete categorie

}
