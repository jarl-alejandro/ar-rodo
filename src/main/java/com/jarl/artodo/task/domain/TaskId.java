package com.jarl.artodo.task.domain;

import com.jarl.artodo.shared.domain.Identifier;
import lombok.NoArgsConstructor;

import java.util.UUID;

@NoArgsConstructor
public class TaskId extends Identifier {

    public TaskId(UUID value) {
        super(value);
    }

    public TaskId(String value) {
        super(UUID.fromString(value));
    }

    public static TaskId generateTaskId () {
        return new TaskId(UUID.randomUUID());
    }
}
