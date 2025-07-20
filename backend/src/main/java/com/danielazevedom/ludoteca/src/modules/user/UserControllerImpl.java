package com.danielazevedom.ludoteca.src.modules.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.danielazevedom.ludoteca.src.modules.user.interfaces.UserController;
import com.danielazevedom.ludoteca.src.modules.user.models.User;
import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserControllerImpl implements UserController{

    @Autowired
    private UserService userService;

    @GetMapping("/me")
    public ResponseEntity<Object> getMe(@RequestHeader("Authorization") String authHeader) {
        try {
            if (authHeader == null || !authHeader.startsWith("Bearer ")) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body("Missing or invalid Authorization header");
            }
            String token = authHeader.substring("Bearer ".length());
            DecodedJWT jwt = JWT.decode(token);
            String googleId = jwt.getSubject();

            Optional<User> userOpt = userService.findByGoogleId(googleId);
            if (userOpt.isPresent()) {
                return ResponseEntity.ok(userOpt.get());
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("User not found for googleId: " + googleId);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("Invalid or expired token: " + e.getMessage());
        }
    }
}