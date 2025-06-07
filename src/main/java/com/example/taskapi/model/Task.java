package com.example.taskapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Getter
@NoArgsConstructor
@Entity
public class Task {

    @Id
    private int id;

    private String title;
    private boolean completed;

}
