package com.taskManagement.task_service.repository;

import com.taskManagement.task_service.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task,Long> {
}
