package com.jarl.artodo.task.domain;

import com.jarl.artodo.shared.domain.StringValueObject;

public class TaskName extends StringValueObject {

    public TaskName(String value) {
        super(value);
    }

    public TaskName() {
        super("");
    }
}
