package com.jcopy.jcopy.service;

import com.jcopy.jcopy.entity.Task;
import com.jcopy.jcopy.entity.User;
import com.jcopy.jcopy.exception.TaskDoesNotExistException;
import com.jcopy.jcopy.exception.UserDoesNotExistException;
import com.jcopy.jcopy.repository.TaskRepository;
import com.jcopy.jcopy.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    @Autowired
    TaskRepository taskRepository;

    @Autowired
    UserService userService;

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task getTask(int id) throws TaskDoesNotExistException {
        Task task = taskRepository.findById(id).orElseThrow(() ->
                new TaskDoesNotExistException("Task doesn't exist."));
        return task;
    }

    public Task createTask(Task task) {
        return null;
    }

    @Transactional
    public Task updateTask(Task taskFromReq) throws TaskDoesNotExistException {
        Task taskFromDb = getTask(taskFromReq.getIdTask());

        taskFromDb.setUpdatedAt(new Date());

        return taskRepository.save(taskFromDb);
    }

    public Task deleteTask(int id) {
        return null;
    }

    public List<Task> getAllTasksCreatedByUserId(int userId) throws UserDoesNotExistException {
        User user = userService.getUserById(userId);
        if (user != null) {
            return taskRepository.findByCreatedByUser(user);
        }
        throw new UserDoesNotExistException("User doesn't exist.");
    }

    public List<Task> getAllTasksAssignedToUser(int userId) throws UserDoesNotExistException {
        User user = userService.getUserById(userId);
        if (user != null) {
            return taskRepository.findByAssignee(user);
        }
        throw new UserDoesNotExistException("User doesn't exist.");
    }

}
