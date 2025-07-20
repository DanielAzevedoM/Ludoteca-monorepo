package com.danielazevedom.ludoteca.src.modules.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.danielazevedom.ludoteca.src.modules.game.models.Game;
import com.danielazevedom.ludoteca.src.modules.category.models.Category;
import com.danielazevedom.ludoteca.src.modules.category.CategoryService;
import java.util.List;
import java.util.Optional;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private CategoryService categoryService;

    public Game createGame(Game game) {
        // Validate that category is provided
        if (game.getCategory() == null || game.getCategory().getId() == null) {
            throw new IllegalArgumentException("Category id must be provided");
        }
        // Fetch and attach full Category
        String categoryId = game.getCategory().getId();
        Category category = categoryService.findById(categoryId)
            .orElseThrow(() -> new IllegalArgumentException("Category not found with id: " + categoryId));
        game.setCategory(category);
        return gameRepository.save(game);
    }

    public List<Game> findAll() {
        return gameRepository.findAll();
    }

    public Optional<Game> findById(String id) {
        return gameRepository.findById(id);
    }
}
