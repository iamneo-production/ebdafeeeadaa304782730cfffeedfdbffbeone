package com.examly.springapp.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.examly.springapp.model.Category;
import com.examly.springapp.repository.CategoryRepo;

import java.util.List;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.examly.springapp.model.Category;
import com.examly.springapp.repository.CategoryRepo;


@RestController
public class CategoryController {

    @Autowired
    private CategoryRepo categoryRepository;

    @GetMapping("/getAllcategory")
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @PostMapping("/addcategory")
    public Category createCategory(@RequestBody Category category) {
        return categoryRepository.save(category);
    }

    // Define other CRUD operations for categories as needed
}
