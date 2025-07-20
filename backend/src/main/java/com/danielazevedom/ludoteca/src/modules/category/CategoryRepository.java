package com.danielazevedom.ludoteca.src.modules.category;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.danielazevedom.ludoteca.src.modules.category.models.Category;

public interface CategoryRepository extends MongoRepository<Category, String> {
    // custom queries can be added here
}