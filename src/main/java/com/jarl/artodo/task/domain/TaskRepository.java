package com.jarl.artodo.task.domain;

import java.util.List;
import java.util.Optional;

public interface TaskRepository {

    void save(Task task);
    Optional<Task> findById(TaskId id);
    List<Task> list();

}
