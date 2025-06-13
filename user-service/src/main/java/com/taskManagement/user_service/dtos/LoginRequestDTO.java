package com.taskManagement.user_service.dtos;

import lombok.Data;

@Data
public class LoginRequestDTO {

    private String email;
    private String password;
}
