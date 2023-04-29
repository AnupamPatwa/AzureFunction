package com.function;

import java.util.*;
import com.microsoft.azure.functions.annotation.*;
import com.restAPI.service.ToDoService;
import com.microsoft.azure.functions.*;

/**
 * Azure Functions with HTTP Trigger.
 */
public class ToDoGet 
{
    /**
     * This function listens at endpoint "/api/toDo-get". Two ways to invoke it using "curl" command in bash:
     * 1. curl -d "HTTP Body" {your host}/api/toDo-get
     * 2. curl {your host}/api/toDo-get?name=HTTP%20Query
     */
    @FunctionName("todo-get")
    public HttpResponseMessage run(
            @HttpTrigger(name = "req2", methods = {HttpMethod.GET}, 
            authLevel = AuthorizationLevel.ANONYMOUS) 
            HttpRequestMessage<Optional<String>> request,
            final ExecutionContext context) 
            {
                context.getLogger().info("Java HTTP trigger processed a request.");
                    // Parse query parameter
                    ToDoService toDoService=new ToDoService();
                    return request.createResponseBuilder(HttpStatus.OK).body(toDoService.getTasks()).build();
            }
}
