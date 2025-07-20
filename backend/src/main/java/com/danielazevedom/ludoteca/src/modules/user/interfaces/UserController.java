package com.danielazevedom.ludoteca.src.modules.user.interfaces;

import org.springframework.http.ResponseEntity;

public interface UserController {

    ResponseEntity<Object> getMe(String authHeader);
}