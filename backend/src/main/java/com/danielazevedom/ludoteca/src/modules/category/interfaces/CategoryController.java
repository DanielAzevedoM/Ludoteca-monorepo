package com.danielazevedom.ludoteca.src.modules.category.interfaces;

import org.springframework.http.ResponseEntity;
import com.danielazevedom.ludoteca.src.modules.category.models.Category;


public interface CategoryController {

    ResponseEntity<Object> create(Category category);

    ResponseEntity<Object> getById(String id);

    ResponseEntity<Object> getAll();
}