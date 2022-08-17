package com.jcopy.jcopy.service.v2;

import com.jcopy.jcopy.controller.ApiBaseController;
import com.jcopy.jcopy.controller.ApiBaseTask;
import com.jcopy.jcopy.entity.Task;
import com.jcopy.jcopy.entity.User;
import com.jcopy.jcopy.model.*;
import com.jcopy.jcopy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class UserTasklistTask<TRequest extends ApiBaseRequest, TResponse extends ApiBaseResponse>
        extends ApiBaseTask<UserTasklistRequest, UserTasklistResponse> {

    @Autowired
    UserRepository userRepository;

    @Override
    public Map<String, Object> performTask(
            ApiBaseController apiBaseController,
            HttpRequest headerResult,
            UserTasklistRequest apiRequest,
            UserTasklistResponse apiResponse) {
        Map<String, Object> resMap = new HashMap<>();

        Optional<User> user = this.userRepository.findById(apiRequest.getIdUser());
        if (user.isPresent()) {
            List<Task> taskList = user.get().getAssignedTaskList();
            apiResponse.setAssignedTaskList(taskList);
            resMap.put("errorMessage", "Success");
            resMap.put("errorCode", "200");
        } else {
            resMap.put("errorMessage", "No user found.");
            resMap.put("errorCode", "404");
        }
        return resMap;
    }
}
