package com.bitsnbytes.productlist.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * OVERALL PURPOSE:
 * This Controller is the internet receptionist specifically for Products.
 * 
 * FLOW:
 * @RestController tells Spring it's an API, not an HTML webpage.
 * @RequestMapping("/api/products") means any internet request trying to visit 'http://website.com/api/products' comes exactly here.
 * 
 * Later, we would add @GetMapping to fetch products and @PostMapping to create them, 
 * using the ProductService to do the heavy lifting safely!
 */
@RestController
@RequestMapping("/api/products")
public class ProductController {

    // Future endpoints (internet URLs) will be mapped here:
    // get product (@GetMapping)
    // create product (@PostMapping)
    // update product (@PutMapping)
    // get product by id (@GetMapping("/{id}"))
    // delete product (@DeleteMapping("/{id}"))

}
