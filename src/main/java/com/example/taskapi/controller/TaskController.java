package com.example.taskapi.controller;

import com.example.taskapi.Task;
import com.example.taskapi.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {

    @Autowired
    private TaskService service;

    @GetMapping("/")
    public String home(){
        return "welcome to home of task rest api practice";
    }

    @GetMapping("/tasks")
    public List<Task> getTasks(){
        return service.getTasks();
    }

    @GetMapping("/tasks/{id}")
    public Task getTaskById(@PathVariable int id){
        return service.getTaskById(id);
    }

    @PostMapping("/tasks")
    public String postTask(Task task){
        service.postTask(task);
        return task + " added";
    }

    @PutMapping("/tasks")
    public String putTask(Task task){
        service.putTask(task);
        return task + " updated";
    }

    @DeleteMapping("/tasks")
    public String deleteTask(int id){
        service.deleteTask(id);
        return "task " + id + " is deleted";
    }
}
