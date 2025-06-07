package com.example.taskapi.service;

import com.example.taskapi.model.Task;
import com.example.taskapi.repo.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class TaskService {

    @Autowired
    private TaskRepo repo;

    public List<Task> getTasks(){
        return repo.findAll();
    }

    public Task getTaskById(int id){
        return repo.findById(id).orElse(new Task(1,null, false));
    }

    public void postTask(Task task){
        repo.save(task);
    }

    public void putTask(Task task){
        repo.save(task);
    }

    public void deleteTask(int id){
        repo.deleteById(id);
    }

    public List<Task> getCompletedTask(boolean status) {

        List<Task> list = new ArrayList<>();

        List<Task> taskList = repo.findAll();

        for (Task task : taskList) {
            if (status == task.isCompleted()) list.add(task);
        }
        return list;
    }
}
