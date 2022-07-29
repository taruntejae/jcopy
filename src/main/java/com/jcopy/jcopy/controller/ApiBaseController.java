package com.jcopy.jcopy.controller;

import com.jcopy.jcopy.model.ApiBaseRequest;
import com.jcopy.jcopy.model.ApiBaseResponse;
import com.jcopy.jcopy.model.HttpRequest;
import org.springframework.http.HttpStatus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;


public class ApiBaseController {
    protected <TRequest extends ApiBaseRequest, TResponse extends ApiBaseResponse, TTask extends ApiBaseTask<TRequest, TResponse>>
    TResponse process(HttpServletRequest httpRequest, HttpServletResponse httpResponse, TRequest payload, TResponse apiResponse, TTask task) {
        HttpRequest headerResult = new HttpRequest();

        Map<String, Object> resMap = task.performTask(this, headerResult, payload, apiResponse);

        if (resMap.get("errorCode").equals("404")) {
            httpResponse.setStatus(HttpStatus.NOT_FOUND.value());
        }

        apiResponse.setErrorCode(resMap.get("errorCode").toString());
        apiResponse.setErrorMessage(resMap.get("errorMessage").toString());

        return apiResponse;
    }

}
