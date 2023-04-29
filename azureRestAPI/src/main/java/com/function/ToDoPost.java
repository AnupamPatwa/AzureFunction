package com.function;

import java.util.*;
import com.microsoft.azure.functions.annotation.*;
import com.restAPI.model.Task;
import com.restAPI.service.ToDoService;
import com.microsoft.azure.functions.*;

/**
 * Azure Functions with HTTP Trigger.
 */
public class ToDoPost {
    /**
     * This function listens at endpoint "/api/ToDoPost". Two ways to invoke it
     * using "curl" command in bash:
     * 1. curl -d "HTTP Body" {your host}/api/ToDoPost
     * 2. curl {your host}/api/ToDoPost?name=HTTP%20Query
     */
    @FunctionName("todo-post")
    public HttpResponseMessage run(
            @HttpTrigger(name = "req", 
            methods = {HttpMethod.POST }, 
            authLevel = AuthorizationLevel.ANONYMOUS) 
            HttpRequestMessage<Optional<Task>> request,
            final ExecutionContext context) {
        context.getLogger().info("Java HTTP trigger processed a request.");

        // Parse query parameter
        // TaskRequest taskRequest = request.getBody().get();
        ToDoService toDoService = new ToDoService();

        if (!request.getBody().isPresent()) {
            return request.createResponseBuilder(HttpStatus.BAD_REQUEST)
                            .body("Document not found.")
                            .build();
        } 
        else {
            // return JSON from to the client
            // Generate document
            final Task body = request.getBody().get();
            return request.createResponseBuilder(HttpStatus.OK).body(body).build();
        }
    }
}
