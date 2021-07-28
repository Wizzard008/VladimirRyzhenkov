package ru.training.at.hw10.core;

import io.restassured.http.Method;
import java.util.HashMap;
import java.util.Map;

public class ApiRequestBuilder {
    private Map<String, String> parameters = new HashMap<>();
    private Method requestMethod = Method.GET;

    public ApiRequestBuilder setMethod (Method method){
        requestMethod = method;
        return this;
    }

    public ApiRequestBuilder setBoardId(String boardId) {
        parameters.put("id", boardId);
        return this;
    }

    public ApiRequestBuilder setBoardName(String boardName) {
        parameters.put("name", boardName);
        return this;
    }

    public ApiRequestBuilder setBoardDescription(String boardDescription) {
        parameters.put("desc", boardDescription);
        return this;
    }

    public ApiRequestBuilder setBoardSubscription(Boolean subscription) {
        parameters.put("subscribed", String.valueOf(subscription));
        return this;
    }

    public TrelloServiceObj buildRequest() {
        return new TrelloServiceObj(parameters, requestMethod);
    }
}
