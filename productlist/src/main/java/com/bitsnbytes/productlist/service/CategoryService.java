package com.bitsnbytes.productlist.service;

import com.bitsnbytes.productlist.dto.CategoryDTO;
import com.bitsnbytes.productlist.entity.Category;
import com.bitsnbytes.productlist.mapper.CategoryMapper;
import com.bitsnbytes.productlist.repository.CategoryRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    private CategoryRepository categoryRepository;

    // create category
    public CategoryDTO createCategory(CategoryDTO categoryDTO) {
        Category category = CategoryMapper.toCategoryEntity(categoryDTO);
        category = CategoryRepository.save(category);
        return CategoryMapper.toCategoryDTO(category);
    }

    // get all categories
    // get category by id
    // delete category
}
