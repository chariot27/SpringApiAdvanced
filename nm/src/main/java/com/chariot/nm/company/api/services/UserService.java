package com.chariot.nm.company.api.services;

import com.chariot.nm.company.api.models.User;
import com.chariot.nm.company.api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(Long id, User user) {
        User existingUser  = getUserById(id);
        if (existingUser  != null) {
            existingUser .setNome(user.getNome());
            existingUser .setSenha(user.getSenha());
            existingUser .setCep(user.getCep());
            return userRepository.save(existingUser );
        } else {
            return null;
        }
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}