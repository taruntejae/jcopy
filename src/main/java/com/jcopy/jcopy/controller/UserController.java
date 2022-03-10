package com.jcopy.jcopy.controller;

import com.jcopy.jcopy.entity.User;
import com.jcopy.jcopy.exception.UserDoesNotExistException;
import com.jcopy.jcopy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("{userId}")
    public User getUserWithId(@PathVariable int userId) throws UserDoesNotExistException {
        return userService.getUserById(userId);
    }
}
