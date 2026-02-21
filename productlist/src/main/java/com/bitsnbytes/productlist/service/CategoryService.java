package com.bitsnbytes.productlist.service;

import com.bitsnbytes.productlist.dto.CategoryDTO;
import com.bitsnbytes.productlist.entity.Category;
import com.bitsnbytes.productlist.mapper.CategoryMapper;
import com.bitsnbytes.productlist.repository.CategoryRepository;

import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

/*
 * OVERALL PURPOSE:
 * The Service layer is where the "Business Logic" lives. 
 * If the Controller is the waiter taking orders, and the Repository is the chef cooking food (database),
 * the Service is the Kitchen Manager making sure the recipe is followed perfectly.
 * 
 * WHY DO WE NEED THIS?
 * We shouldn't put complex rules (like checking if a name is valid, saving to the database, calculating discounts, etc.) 
 * directly in the Controller. Keeping it here makes the code organized, easy to test, and reusable.
 */

// @Service tells Spring Boot: "This class holds our business rules. Please create an object of this class 
// automatically and map it into memory so other classes can use it."
@Service
// @AllArgsConstructor is from Lombok. It automatically generates a constructor
// that passes in our variables (categoryRepository).
// This is called "Dependency Injection". Spring Boot automatically hands this
// Service the exact Repository it needs.
@AllArgsConstructor
public class CategoryService {

    // We declare a variable for our database bridge (repository).
    private CategoryRepository categoryRepository;

    /*
     * The method that handles the actual creation of a category.
     * FLOW:
     * 1. Receive data from the user (categoryDTO) via the Controller.
     * 2. Translate it to an Entity so the database understands it.
     * 3. Ask Repository to save the Entity in the database.
     * 4. Translate the newly saved Entity back to a DTO to show the user it was
     * successful.
     */
    public CategoryDTO createCategory(CategoryDTO categoryDTO) {

        // Step 1: Convert the incoming DTO (user data) into an Entity (database data)
        // using our Mapper.
        Category category = CategoryMapper.toCategoryEntity(categoryDTO);

        // Step 2: Use the repository to physically INSERT the new row into the database
        // table!
        // The .save() method returns the final saved copy (which now includes the
        // auto-generated ID from the database).
        category = categoryRepository.save(category);

        // Step 3: Convert the freshly saved database Entity back into a safe DTO, and
        // return it to the Controller.
        return CategoryMapper.toCategoryDTO(category);
    }

    // Future placeholders for API operations:
    // get all categories
    // get category by id
    // delete category
}
