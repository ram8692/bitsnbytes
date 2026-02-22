package com.bitsnbytes.productlist.service;

import com.bitsnbytes.productlist.dto.ProductDTO;
import com.bitsnbytes.productlist.entity.Category;
import com.bitsnbytes.productlist.entity.Product;
import com.bitsnbytes.productlist.mapper.ProductMapper;
import com.bitsnbytes.productlist.repository.CategoryRepository;
import com.bitsnbytes.productlist.repository.ProductRepository;
import lombok.AllArgsConstructor;
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
@AllArgsConstructor
@Service
public class ProductService {

    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;
    // Future business logic goes here:
    // inject ProductRepository
    // inject CategoryRepository
    // create product, get all products, update product, delete product etc.
    public ProductDTO createProduct(ProductDTO productDTO) {

        Category category = CategoryRepository.findById(productDTO.getCategory_id()).orElseThrow(()->new RuntimeException("Category not found"));
        Product product = ProductMapper.toProductEntity(productDTO);
        product = ProductRepository.save(product);
       return ProductMapper.toProductDTO(product);

    }
}
