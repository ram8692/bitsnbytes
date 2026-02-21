package com.bitsnbytes.productlist.mapper;

import com.bitsnbytes.productlist.dto.CategoryDTO;
import com.bitsnbytes.productlist.entity.Category;

/*
 * OVERALL PURPOSE:
 * The Mapper is a helper class. Its only job is to translate (or "map") data between 
 * our database object (Category Entity) and our frontend-facing object (Category DTO).
 * 
 * HOW THE FLOW WORKS:
 * 1. User sends a CategoryDTO from their browser.
 * 2. Mapper converts DTO -> Entity so we can save it in the database.
 * 3. Database saves it and gives back an Entity.
 * 4. Mapper converts Entity -> DTO to send the successful result back to the user's browser.
 * 
 * WHY NOT WRITE THIS DIRECTLY IN THE CONTROLLER?
 * Keeping conversion logic here makes our code organized and prevents our the rest of our application from getting messy.
 */
public class CategoryMapper {

    /*
     * We make this method "static" so we can call it directly via
     * CategoryMapper.toCategoryDTO()
     * without having to create a `new CategoryMapper()` object every single time.
     * It saves memory.
     */
    public static CategoryDTO toCategoryDTO(Category category) {

        // Safety check: if the database gave us nothing, we return nothing to avoid
        // crashes (NullPointerException).
        if (category == null) {
            return null;
        }

        // Step 1: Create a brand new, empty DTO that we are preparing to send to the
        // user.
        CategoryDTO categoryDTO = new CategoryDTO();

        // Step 2: Copy the ID from the database Entity into the DTO.
        categoryDTO.setId(category.getId());

        // Step 3: Copy the Name from the database Entity into the DTO.
        categoryDTO.setName(category.getName());

        // Step 4: Handle the list of products.
        // If the category has products inside it, we must also convert every single
        // Product Entity into a Product DTO.
        // We use .stream().map() which is a fast way to loop through a list and convert
        // each item.
        if (category.getProducts() != null) {
            categoryDTO.setProducts(category.getProducts().stream().map(ProductMapper::toProductDTO).toList());
        }

        // Step 5: Hand back the fully packed DTO.
        return categoryDTO;
    }

    /*
     * This method does the exact reverse. It takes the DTO (what the user typed in)
     * and converts it into an Entity (which the database understands).
     */
    public static Category toCategoryEntity(CategoryDTO categoryDTO) {

        // Step 1: Create a brand new, empty database Entity.
        Category category = new Category();

        // Step 2: Extract the user-provided name from the DTO, and push it into the
        // Entity.
        category.setName(categoryDTO.getName());

        // (Note: We usually don't set the ID here because the database automatically
        // creates a new ID for new items!)

        // Step 3: Hand back the Entity, ready to be saved to the database.
        return category;
    }
}
