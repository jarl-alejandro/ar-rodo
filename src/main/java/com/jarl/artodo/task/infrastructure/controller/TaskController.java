package com.jarl.artodo.task.infrastructure.controller;

import com.jarl.artodo.task.application.TaskDTO;
import com.jarl.artodo.task.application.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService service;

    public TaskController(TaskService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<TaskDTO>> listAllTasks () {
        List<TaskDTO> tasks = service.listAll();
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskDTO> findById(@PathVariable("id") String id) {
        try {
            TaskDTO task = service.findById(id);
            return new ResponseEntity<>(task, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping
    public ResponseEntity<Void> createTask (@RequestBody TaskDTO taskDTO) {
        service.create(taskDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
