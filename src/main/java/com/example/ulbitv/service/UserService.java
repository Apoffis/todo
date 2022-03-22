package com.example.ulbitv.service;

import com.example.ulbitv.entity.UserEntity;
import com.example.ulbitv.exceptions.UserAlreadyExists;
import com.example.ulbitv.exceptions.UserNotFoundException;
import com.example.ulbitv.models.User;
import com.example.ulbitv.rpository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserEntity registration(UserEntity user) throws UserAlreadyExists {
        if (userRepository.findByUsername(user.getUsername()) != null) {
            throw new UserAlreadyExists("User Already Exists");
        }
        return userRepository.save(user);
    }

    public User getUser(Long id) {
        Optional<UserEntity> user = userRepository.findById(id);
        if (user.isEmpty()) {
            throw new UserNotFoundException(id);
        }

        return User.toModel(user.get());
    }

    public List<UserEntity> getUsers() {
        return (List<UserEntity>) userRepository.findAll();
    }

    public Long delete(Long id) {
        userRepository.deleteById(id);
        return id;
    }

}
