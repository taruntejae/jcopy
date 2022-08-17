package com.jcopy.jcopy.model;

import com.jcopy.jcopy.entity.User;
import lombok.Data;

import java.util.List;

@Data
public class UserListRequest extends ApiBaseRequest {
    List<User> userList;
}
