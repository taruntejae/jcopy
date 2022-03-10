package com.jcopy.jcopy.repository;

import com.jcopy.jcopy.entity.Task;
import com.jcopy.jcopy.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface TaskRepository extends CrudRepository<Task, Integer> {
    List<Task> findAll();
    Optional<Task> findById(int taskId);
    List<Task> findByAssignee(User user);
    List<Task> findByCreatedByUser(User user);
}
