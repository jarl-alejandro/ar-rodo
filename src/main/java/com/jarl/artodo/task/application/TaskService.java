package com.jarl.artodo.task.application;

import com.jarl.artodo.shared.domain.Service;
import com.jarl.artodo.task.domain.*;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskService {

    private final TaskRepository repository;

    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    public void create(TaskDTO taskDTO) {
        TaskId id = TaskId.generateTaskId();
        TaskName name = new TaskName(taskDTO.getName());
        TaskDescription description = new TaskDescription(taskDTO.getDescription());
        TaskComplete complete = new TaskComplete();

        Task task = Task.create(id, name, description, complete);
        repository.save(task);
    }

    public TaskDTO findById(String id) throws Exception {
        TaskId taskId = new TaskId(id);
        return repository.findById(taskId)
            .map(TaskDTO::mapperTaskDTO)
            .orElseThrow(() -> new Exception("task no exist"));
    }

    public List<TaskDTO> listAll() {
        return repository.list().stream()
            .map(TaskDTO::mapperTaskDTO)
            .collect(Collectors.toList());
    }

}
