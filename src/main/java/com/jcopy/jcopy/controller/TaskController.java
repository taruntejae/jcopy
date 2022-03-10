package com.jcopy.jcopy.controller;

import com.jcopy.jcopy.entity.Task;
import com.jcopy.jcopy.exception.TaskDoesNotExistException;
import com.jcopy.jcopy.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("task")
public class TaskController {

    @Autowired
    TaskService taskService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @GetMapping("{taskId}")
    @ResponseStatus(HttpStatus.OK)
    public Task getTaskWithId(@PathVariable int taskId) throws TaskDoesNotExistException {
        return taskService.getTask(taskId);
    }

    @PostMapping("update")
    public Task updateTask(@RequestBody Task task) throws TaskDoesNotExistException {
        return taskService.updateTask(task);
    }
}
