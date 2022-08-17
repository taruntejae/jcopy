package com.jcopy.jcopy.controller.v2;

import com.jcopy.jcopy.controller.ApiBaseController;
import com.jcopy.jcopy.model.*;
import com.jcopy.jcopy.service.v2.UserDetailsTask;
import com.jcopy.jcopy.service.v2.UserListTask;
import com.jcopy.jcopy.service.v2.UserTasklistTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping(value = "/v2/user")
public class UserControllerV2 extends ApiBaseController {

    @Autowired
    UserListTask<UserListRequest, UserListResponse> userListTask;
    @Autowired
    UserDetailsTask<UserDetailsRequest, UserDetailsResponse> userDetailsTask;

    @Autowired
    UserTasklistTask<UserTasklistRequest, UserTasklistResponse> userTasklistTask;

    @PostMapping(value = "/list")
    public UserListResponse fetchAllUsers(@RequestBody final UserListRequest payload, final HttpServletRequest httpRequest, final HttpServletResponse httpResponse) {
        return process(httpRequest, httpResponse, payload, new UserListResponse(), userListTask);
    }

    @PostMapping
    public UserDetailsResponse fetchUser(@RequestBody final UserDetailsRequest payload, final HttpServletRequest httpRequest, final HttpServletResponse httpResponse) {
        return process(httpRequest, httpResponse, payload, new UserDetailsResponse(), userDetailsTask);
    }

    @PostMapping(value = "/task/list")
    public UserTasklistResponse fetchUserTasklist(@RequestBody final UserTasklistRequest payload, final HttpServletRequest httpRequest, final HttpServletResponse httpResponse) {
        return process(httpRequest, httpResponse, payload, new UserTasklistResponse(), userTasklistTask);
    }
}
