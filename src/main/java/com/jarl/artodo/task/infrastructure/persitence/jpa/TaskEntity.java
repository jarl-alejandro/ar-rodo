package com.jarl.artodo.task.infrastructure.persitence.jpa;

import com.jarl.artodo.task.domain.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Entity
@Table(name = "tasks")
@NoArgsConstructor
public class TaskEntity {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "complete")
    private Boolean complete;

    public TaskEntity(String id, String name, String description, Boolean complete) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.complete = complete;
    }

    public static Task mapperToTask(TaskEntity taskEntity) {
        return new Task(
            new TaskId(taskEntity.getId()),
            new TaskName(taskEntity.getName()),
            new TaskDescription(taskEntity.getDescription()),
            new TaskComplete(taskEntity.getComplete())
        );
    }
}
