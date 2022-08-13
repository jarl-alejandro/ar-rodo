package com.jarl.artodo.task.domain;

import lombok.Getter;

@Getter
public class Task {

    private final TaskId id;
    private final TaskName name;
    private final TaskDescription description;
    private final TaskComplete complete;

    public Task(TaskId id, TaskName name, TaskDescription description, TaskComplete complete) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.complete = complete;
    }

    public Task() {
        this.id = null;
        this.name = null;
        this.description = null;
        this.complete = null;
    }

    public static Task create (TaskId id, TaskName name, TaskDescription description, TaskComplete complete) {
        return new Task(id, name, description, complete);
    }
}
