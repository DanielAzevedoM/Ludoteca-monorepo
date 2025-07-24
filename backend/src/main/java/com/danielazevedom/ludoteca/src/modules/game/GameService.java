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

    public Optional<Game> findById(String id) {
        return gameRepository.findById(id);
    }

    public List<Game> findAll() {
        return gameRepository.findAll();
    }

    public Game updateGame(String id, Game details) {
        Game g = gameRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Game not found with id: " + id));
        g.setName(details.getName());
        g.setDescription(details.getDescription());
        g.setCoverImageUrl(details.getCoverImageUrl());
        // atrelamento obrigatório de categoria
        String catId = details.getCategory().getId();
        Category cat = categoryService.findById(catId)
            .orElseThrow(() -> new IllegalArgumentException("Category not found with id: " + catId));
        g.setCategory(cat);
        return gameRepository.save(g);
    }

    public void deleteGame(String id) {
        gameRepository.deleteById(id);
    }
}
