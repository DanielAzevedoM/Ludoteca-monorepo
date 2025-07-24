// MODIFICATION BASED ON: Ludoteca-monorepo/backend/src/main/java/com/danielazevedom/ludoteca/src/modules/category/interfaces/CategoryController.java
package com.danielazevedom.ludoteca.src.modules.category.interfaces;

import org.springframework.http.ResponseEntity;
import com.danielazevedom.ludoteca.src.modules.category.models.Category;


public interface CategoryController {

    ResponseEntity<Object> create(Category category);
    ResponseEntity<Object> getById(String id);
    ResponseEntity<Object> getAll();
    ResponseEntity<Object> update(String id, Category category);
    ResponseEntity<Object> delete(String id);
}
