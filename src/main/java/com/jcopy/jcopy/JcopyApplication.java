package com.jcopy.jcopy;

import com.jcopy.jcopy.entity.User;
import com.jcopy.jcopy.entity.Task;
import com.jcopy.jcopy.repository.TaskRepository;
import com.jcopy.jcopy.repository.UserRepository;
import com.jcopy.jcopy.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class JcopyApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(JcopyApplication.class, args);
    }

    @Autowired
    UserRepository userRepository;

    @Autowired
    TaskService taskService;

    @Override
    public void run(String... args) throws Exception {
    }
}
