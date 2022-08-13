package com.jarl.artodo.task.domain;

import com.jarl.artodo.shared.domain.StringValueObject;

public class TaskDescription extends StringValueObject {

    public TaskDescription(String value) {
        super(value);
    }

    public TaskDescription() {
        super("");
    }
}
