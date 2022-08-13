package com.jarl.artodo.task.infrastructure.persitence;

import com.jarl.artodo.task.domain.Task;
import com.jarl.artodo.task.domain.TaskId;
import com.jarl.artodo.task.domain.TaskRepository;
import com.jarl.artodo.task.infrastructure.persitence.jpa.TaskEntity;
import com.jarl.artodo.task.infrastructure.persitence.jpa.TaskJpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MysqlTaskRepository implements TaskRepository {

    private final TaskJpaRepository repository;

    public MysqlTaskRepository(TaskJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public void save(Task task) {
        TaskEntity taskEntity = new TaskEntity(
            task.getId().toString(),
            task.getName().value(),
            task.getDescription().value(),
            task.getComplete().value()
        );

        repository.save(taskEntity);
    }

    @Override
    public Optional<Task> findById(TaskId id) {
        return repository.findById(id.toString())
            .map(TaskEntity::mapperToTask);
    }

    @Override
    public List<Task> list() {
        return repository.findAll().stream()
            .map(TaskEntity::mapperToTask)
            .collect(Collectors.toList());
    }
}
