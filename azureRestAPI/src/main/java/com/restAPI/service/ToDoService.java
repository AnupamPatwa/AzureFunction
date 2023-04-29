package com.restAPI.service;

import java.util.ArrayList;
import java.util.List;

import com.restAPI.model.Task;

public class ToDoService {
    private List<Task> tasks=new ArrayList<>();

    public List<Task> getTasks(){

        List<Task> taskList = new ArrayList<>();
        taskList.add(new Task("1", "task1", "This is task 1"));
        taskList.add(new Task("2", "task2", "This is task 2"));
        taskList.add(new Task("3", "task3", "This is task 3"));

        this.tasks.addAll(taskList);
        return this.tasks;

    }


    public Task createTask(String name,String id, String description)
    {
        Task task=new Task(name,id,description);
        tasks.add(task);
        return task;
    }
}
