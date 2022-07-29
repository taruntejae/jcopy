package com.jcopy.jcopy.controller;

import com.jcopy.jcopy.model.ApiBaseRequest;
import com.jcopy.jcopy.model.ApiBaseResponse;
import com.jcopy.jcopy.model.HttpRequest;

import java.util.Map;

public abstract class ApiBaseTask<TRequest extends ApiBaseRequest, TResponse extends ApiBaseResponse> {
    public abstract Map<String, Object> performTask(ApiBaseController apiBaseController,
                                                    HttpRequest headerResult, TRequest apiRequest, TResponse apiResponse);
}
