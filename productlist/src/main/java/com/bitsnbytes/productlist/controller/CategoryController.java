package com.bitsnbytes.productlist.controller;

import com.bitsnbytes.productlist.dto.CategoryDTO;
import com.bitsnbytes.productlist.service.CategoryService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    // get all cateories
    // create categories
    @PostMapping
    public CategoryDTO createCategory(@RequestBody CategoryDTO categoryDTO) {

        return categoryService.createCategory(categoryDTO);

    }
    // get category by id
    // delete categorie

}
