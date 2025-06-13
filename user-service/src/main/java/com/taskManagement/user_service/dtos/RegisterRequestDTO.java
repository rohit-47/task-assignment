package com.taskManagement.user_service.dtos;

import com.taskManagement.user_service.enums.Role;
import lombok.Data;

@Data
public class RegisterRequestDTO {

    private String email;
    private String password;

    private String firstName;
    private String lastName;

    private String role;
    private String country;
}
