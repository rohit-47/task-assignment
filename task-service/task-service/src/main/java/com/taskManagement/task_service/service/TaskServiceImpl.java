package com.taskManagement.task_service.service;

import com.taskManagement.task_service.dto.CreateTaskRequest;
import com.taskManagement.task_service.dto.UpdateTaskRequest;
import com.taskManagement.task_service.entity.Task;
import com.taskManagement.task_service.interfaces.TaskService;
import com.taskManagement.task_service.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Optional<Task> fetchTaskById(Long id) {
        return taskRepository.findById(id);
    }

    @Override
    public Task createTask(CreateTaskRequest createTaskRequest) {
        Task request = Task.builder()
                .title(createTaskRequest.getTitle())
                .description(createTaskRequest.getDescription())
                .createdBy(createTaskRequest.getCreatedBy())
                .assignedTo(createTaskRequest.getAssignedTo())
                .assignedBy(createTaskRequest.getAssignedBy())
                .createdAt(LocalDateTime.now())
                .build();
        return taskRepository.save(request);
    }

    @Override
    public Task updateTaskById(Long id, UpdateTaskRequest updateTaskRequest) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found with id: " + id));
        task.setTitle(updateTaskRequest.getTitle());
        task.setDescription(updateTaskRequest.getDescription());
        task.setAssignedBy(updateTaskRequest.getAssignedBy());
        task.setAssignedTo(updateTaskRequest.getAssignedTo());
        return taskRepository.save(task);
    }

    @Override
    public Task deleteTaskById(Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found with id: " + id));
        taskRepository.deleteById(id);
        return task;
    }

}
