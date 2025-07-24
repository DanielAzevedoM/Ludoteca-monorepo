package com.danielazevedom.ludoteca.src.modules.game.interfaces;

import org.springframework.http.ResponseEntity;
import com.danielazevedom.ludoteca.src.modules.game.models.Game;


public interface GameController {

    ResponseEntity<Object> create(Game game);
    ResponseEntity<Object> getById(String id);
    ResponseEntity<Object> getAll();
    ResponseEntity<Object> update(String id, Game game);
    ResponseEntity<Object> delete(String id);
}
