package com.danielazevedom.ludoteca.src.modules.game;

import com.danielazevedom.ludoteca.src.modules.game.interfaces.GameController;
import com.danielazevedom.ludoteca.src.modules.game.models.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/games")
public class GameControllerImpl implements GameController {

    @Autowired
    private GameService gameService;

    @Override
    @PostMapping
    public ResponseEntity<Object> create(@RequestBody Game game) {
        try {
            Game saved = gameService.createGame(game);
            return ResponseEntity.ok(saved);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao criar game: " + e.getMessage());
        }
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@PathVariable("id") String id) {
        try {
            Optional<Game> gameOpt = gameService.findById(id);
            if (gameOpt.isPresent()) {
                return ResponseEntity.ok(gameOpt.get());
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("Game não encontrado com id: " + id);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao buscar game: " + e.getMessage());
        }
    }

    @Override
    @GetMapping
    public ResponseEntity<Object> getAll() {
        try {
            List<Game> list = gameService.findAll();
            return ResponseEntity.ok(list);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao listar games: " + e.getMessage());
        }
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable("id") String id, @RequestBody Game game) {
        try {
            Game updated = gameService.updateGame(id, game);
            return ResponseEntity.ok(updated);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao atualizar game: " + e.getMessage());
        }
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") String id) {
        try {
            gameService.deleteGame(id);
            return ResponseEntity.ok("Game deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao excluir game: " + e.getMessage());
        }
    }
}

