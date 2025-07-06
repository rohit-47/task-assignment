package com.taskManagement.task_service.interfaces;

import com.taskManagement.task_service.dto.CreateTaskRequest;
import com.taskManagement.task_service.dto.UpdateTaskRequest;
import com.taskManagement.task_service.entity.Task;

import java.util.List;
import java.util.Optional;

public interface TaskService {
    List<Task> getAllTasks();
    Optional<Task> fetchTaskById(Long id);
    Task createTask(CreateTaskRequest createTaskRequest);
    Task updateTaskById(Long id, UpdateTaskRequest updateTaskRequest);
    Task deleteTaskById(Long id);
}
