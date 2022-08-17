package com.jcopy.jcopy.model;

import com.jcopy.jcopy.entity.User;
import lombok.Data;

@Data
public class UserDetailsResponse extends ApiBaseResponse{
    User user;
}
