package com.danielazevedom.ludoteca.src.modules.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danielazevedom.ludoteca.src.modules.user.models.User;

import java.time.Instant;
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
                .picture((String) profile.get("picture"))           // Preenche a foto
                .createdAt(Instant.now())                            // Data de criação
                .updatedAt(Instant.now())                            // Data de última atualização
                .isDeleted(false)                                    // Não está deletado
                .isAdmin(false)                                      // Usuário comum por padrão
                .build();

            return userRepository.save(newUser);
        }
    }

    public Optional<User> findByGoogleId(String googleId) {
        return userRepository.findByGoogleId(googleId);
    }

    public User updateUser(String id, User userDetails) {
        User user = userRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("User not found with id: " + id));
        user.setEmail(userDetails.getEmail());
        user.setName(userDetails.getName());
        user.setPicture(userDetails.getPicture());
        user.setUpdatedAt(Instant.now());
        return userRepository.save(user);
    }

    public void softDeleteUser(String id) {
        userRepository.findById(id).ifPresent(u -> {
            u.setDeleted(true);
            u.setUpdatedAt(Instant.now());
            userRepository.save(u);
        });
    }

    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }
}

