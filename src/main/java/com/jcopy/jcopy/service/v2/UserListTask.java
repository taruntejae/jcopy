package com.jcopy.jcopy.service.v2;

import com.jcopy.jcopy.controller.ApiBaseController;
import com.jcopy.jcopy.controller.ApiBaseTask;
import com.jcopy.jcopy.entity.User;
import com.jcopy.jcopy.model.*;
import com.jcopy.jcopy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserListTask<TRequest extends ApiBaseRequest, TResponse extends ApiBaseResponse> extends ApiBaseTask<UserListRequest, UserListResponse> {
    @Autowired
    UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Map<String, Object> performTask(ApiBaseController apiBaseController, HttpRequest headerResult, UserListRequest apiRequest, UserListResponse apiResponse) {
        Map<String, Object> respObj = new HashMap<>();

        List<User> users = this.getAllUsers();
        apiResponse.setUserList(users);
        respObj.put("errorMessage", "success");
        respObj.put("errorCode", "0");
        return respObj;
    }
}
