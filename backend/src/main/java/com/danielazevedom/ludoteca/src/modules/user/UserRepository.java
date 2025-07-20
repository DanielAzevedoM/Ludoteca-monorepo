package com.danielazevedom.ludoteca.src.modules.user;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.danielazevedom.ludoteca.src.modules.user.models.User;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findByGoogleId(String googleId);
    Optional<User> findByEmail(String email);
}