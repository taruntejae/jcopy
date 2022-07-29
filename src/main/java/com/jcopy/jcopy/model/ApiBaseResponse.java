package com.jcopy.jcopy.model;

import lombok.Data;

@Data
public class ApiBaseResponse {
    private String errorCode;
    private String errorMessage;
}
