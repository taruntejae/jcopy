package com.jcopy.jcopy.model;

import com.jcopy.jcopy.entity.User;
import lombok.Data;

import java.util.List;

@Data
public class UserListResponse extends ApiBaseResponse {
    private List<User> userList;
}
