package com.bitsnbytes.productlist.mapper;

import com.bitsnbytes.productlist.dto.ProductDTO;
import com.bitsnbytes.productlist.entity.Category;
import com.bitsnbytes.productlist.entity.Product;

/*
 * OVERALL PURPOSE:
 * The Mapper translates back and forth between the internet-safe ProductDTO and the database-ready Product Entity.
 */
public class ProductMapper {

    /*
     * FLOW: Entity -> DTO (Database reading data to send to User)
     * We receive the bulky Database Product Entity, and we package it into a clean,
     * lightweight DTO.
     */
    public static ProductDTO toProductDTO(Product product) {

        // We create a new DTO using the "All Arguments Constructor" provided by Lombok.
        return new ProductDTO(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getCategory().getId() // We grab ONLY the ID of the category, not the whole category object!
        );
    }

    /*
     * FLOW: DTO -> Entity (User sending data to save to Database)
     * To save a product, the database requires an entire Category object to
     * establish the relationship,
     * but the incoming DTO only gave us a `category_id` (a simple number).
     * So, this converter method takes BOTH the DTO and the actual Category object
     * that we fetched from the database!
     */
    public static Product toProductEntity(ProductDTO productDTO, Category category) {

        // Step 1. Create a blank Entity ready for the database
        Product product = new Product();

        // Step 2. Copy the simple text/number fields over
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());

        // Step 3. Attach the full Category object to establish the database
        // relationship
        product.setCategory(category);

        // Step 4. Return the fully formed object, ready to be saved securely in the
        // database
        return product;
    }

}
