package com.bitsnbytes.productlist.controller;

import com.bitsnbytes.productlist.dto.ProductDTO;
import com.bitsnbytes.productlist.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
@AllArgsConstructor
public class ProductController {

    private ProductService productService;

    // Future endpoints (internet URLs) will be mapped here:
    // get product (@GetMapping)
    // create product (@PostMapping)
    @PostMapping
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO productDTO) {
        ProductDTO savedProductDTO = productService.createProduct(productDTO);
        return new ResponseEntity<>(savedProductDTO, HttpStatus.CREATED);

    }

    // update product (@PutMapping)
    // get product by id (@GetMapping("/{id}"))
    // delete product (@DeleteMapping("/{id}"))

}
