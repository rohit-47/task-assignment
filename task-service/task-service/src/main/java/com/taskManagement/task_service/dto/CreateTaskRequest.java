package com.taskManagement.task_service.dto;

import lombok.Data;

@Data
public class CreateTaskRequest {

    private String title;
    private String description;
    private String assignedBy;
    private String assignedTo;
    private String createdBy;
}
