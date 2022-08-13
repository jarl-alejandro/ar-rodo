package com.jarl.artodo.task.domain;

import java.util.Objects;

public class TaskComplete {
    private final Boolean value;

    public TaskComplete(Boolean value) {
        this.value = value;
    }

    public TaskComplete() {
        this.value = Boolean.FALSE;
    }

    public Boolean value() {
        return value;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaskComplete that = (TaskComplete) o;
        assert value != null;
        return value.equals(that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
