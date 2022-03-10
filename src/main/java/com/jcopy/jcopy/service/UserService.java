package com.jcopy.jcopy.service;

import com.jcopy.jcopy.entity.User;
import com.jcopy.jcopy.exception.UserDoesNotExistException;
import com.jcopy.jcopy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(int userId) throws UserDoesNotExistException {
        return userRepository.findById(userId).orElseThrow(() -> new UserDoesNotExistException(String.format("User doesn't exist.")));
    }
}
