package com.danielazevedom.ludoteca.src.modules.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import com.danielazevedom.ludoteca.src.modules.category.interfaces.CategoryController;
import com.danielazevedom.ludoteca.src.modules.category.models.Category;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categories")
public class CategoryControllerImpl implements CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody Category category) {
        try {
            Category saved = categoryService.createCategory(category);
            return ResponseEntity.ok(saved);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao criar categoria: " + e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@PathVariable("id") String id) {
        try {
            Optional<Category> catOpt = categoryService.findById(id);
            if (catOpt.isPresent()) {
                return ResponseEntity.ok(catOpt.get());
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("Categoria não encontrada com id: " + id);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao buscar categoria: " + e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<Object> getAll() {
        try {
            List<Category> list = categoryService.findAll();
            return ResponseEntity.ok(list);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao listar categorias: " + e.getMessage());
        }
    }
}
