package com.jcopy.jcopy.model;

import com.jcopy.jcopy.entity.Task;
import lombok.Data;

import java.util.List;

@Data
public class UserTasklistResponse extends ApiBaseResponse {
    List<Task> assignedTaskList;
}
