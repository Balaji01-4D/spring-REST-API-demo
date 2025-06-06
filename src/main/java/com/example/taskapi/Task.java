package com.example.taskapi;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
@AllArgsConstructor
@Getter
public class Task {

    private int id;
    private String title;
    private boolean completed;

}
