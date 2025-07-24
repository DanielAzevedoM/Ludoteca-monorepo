// MODIFICATION BASED ON: Ludoteca-monorepo/backend/src/main/java/com/danielazevedom/ludoteca/src/modules/user/interfaces/UserController.java
package com.danielazevedom.ludoteca.src.modules.user.interfaces;

import org.springframework.http.ResponseEntity;

import com.danielazevedom.ludoteca.src.modules.user.models.User;

public interface UserController {

    ResponseEntity<Object> getMe(String authHeader);
    ResponseEntity<Object> update(String id, User user);
    ResponseEntity<Object> softDelete(String id);
    ResponseEntity<Object> delete(String id);
}
