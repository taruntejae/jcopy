package com.jcopy.jcopy.exception;

import lombok.Data;

@Data
public class ErrorResponse {
    private String errorMessage;
    private String path;
}
