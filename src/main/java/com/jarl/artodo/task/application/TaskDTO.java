package com.jarl.artodo.task.application;

import com.jarl.artodo.task.domain.Task;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TaskDTO {
    private String id;
    private String name;
    private String description;
    private Boolean complete;

    public TaskDTO(String id, String name, String description, Boolean complete) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.complete = complete;
    }

    public static TaskDTO mapperTaskDTO(Task task) {
        return new TaskDTO(
            task.getId().toString(),
            task.getName().value(),
            task.getDescription().value(),
            task.getComplete().value()
        );
    }
}
