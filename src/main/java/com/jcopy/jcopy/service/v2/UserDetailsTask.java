package com.jcopy.jcopy.service.v2;

import com.jcopy.jcopy.controller.ApiBaseController;
import com.jcopy.jcopy.controller.ApiBaseTask;
import com.jcopy.jcopy.entity.User;
import com.jcopy.jcopy.model.*;
import com.jcopy.jcopy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class UserDetailsTask<TRequest extends ApiBaseRequest, TResponse extends ApiBaseResponse>
        extends ApiBaseTask<UserDetailsRequest, UserDetailsResponse> {

    @Autowired
    UserRepository userRepository;

    @Override
    public Map<String, Object> performTask(ApiBaseController apiBaseController, HttpRequest headerResult, UserDetailsRequest apiRequest, UserDetailsResponse apiResponse) {
        Map<String, Object> respObj = new HashMap<>();

        Optional<User> user = this.userRepository.findById(apiRequest.getId());

        if (user.isPresent()) {
            apiResponse.setUser(user.get());
            respObj.put("errorMessage", "Success");
            respObj.put("errorCode", "200");
        } else {
            apiResponse.setUser(null);
            respObj.put("errorMessage", "No users found with the userId: " + apiRequest.getId());
            respObj.put("errorCode", "404");
        }
        return respObj;
    }
}
