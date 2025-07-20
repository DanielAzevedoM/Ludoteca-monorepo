package com.danielazevedom.ludoteca.src.modules.game;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.danielazevedom.ludoteca.src.modules.game.models.Game;

public interface GameRepository extends MongoRepository<Game, String> {
    // Additional query methods if needed
}
