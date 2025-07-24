// MODIFICATION BASED ON: Ludoteca-monorepo/backend/src/main/java/com/danielazevedom/ludoteca/src/modules/category/CategoryService.java
package com.danielazevedom.ludoteca.src.modules.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.danielazevedom.ludoteca.src.modules.category.models.Category;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    public Optional<Category> findById(String id) {
        return categoryRepository.findById(id);
    }

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public Category updateCategory(String id, Category details) {
        Category c = categoryRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Category not found with id: " + id));
        c.setName(details.getName());
        c.setDescription(details.getDescription());
        return categoryRepository.save(c);
    }

    public void deleteCategory(String id) {
        categoryRepository.deleteById(id);
    }
}
