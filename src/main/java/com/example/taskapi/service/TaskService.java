package com.example.taskapi.service;

import com.example.taskapi.Task;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Service
public class TaskService {

    private final List<Task> taskList = new ArrayList<>(
            Arrays.asList(
                    new Task(1,"i have to go to mall",false),
                    new Task(2,"i have to prepare for exam",false),
                    new Task(3,"i have to write down the problems",false),
                    new Task(4,"i have to get a new bus pass",false),
                    new Task(5,"i have to attend meeting at 9:00",false)
            )
    );

    private int searchById(int id){
        for (int i = 0; i < taskList.size(); i++){
            if (id == taskList.get(i).getId()) return i;
        }
        return -1;
    }

    public List<Task> getTasks(){
        return this.taskList;
    }

    public Task getTaskById(int id){
        return taskList.get(this.searchById(id));
    }

    public void postTask(Task task){
        this.taskList.add(task);
    }

    public void putTask(Task task){
        int index = this.searchById(task.getId());
        taskList.set(index, task);
    }

    public void deleteTask(int id){
        int index = this.searchById(id);
        if (index >= 0) taskList.remove(index);
    }

    public List<Task> getCompletedTask(boolean status) {

        List<Task> list = new ArrayList<>();

        for (Task task : taskList) {
            if (status == task.isCompleted()) list.add(task);
        }
        return list;
    }
}
