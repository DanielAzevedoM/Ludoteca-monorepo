package com.danielazevedom.ludoteca.src.modules.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danielazevedom.ludoteca.src.modules.user.models.User;

import java.util.Map;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User findOrCreateUserFromGoogle(Map<String, Object> profile) {
        String googleId = (String) profile.get("id");
        Optional<User> existing = userRepository.findByGoogleId(googleId);
        if (existing.isPresent()) {
            return existing.get();
        } else {
            User newUser = User.builder()
                    .googleId(googleId)
                    .email((String) profile.get("email"))
                    .name((String) profile.get("name"))
                    .build();
            return userRepository.save(newUser);
        }
    }

    public Optional<User> findByGoogleId(String googleId) {
        return userRepository.findByGoogleId(googleId);
    }
}
