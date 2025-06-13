package com.taskManagement.user_service.service;

import com.taskManagement.user_service.enums.Role;
import org.springframework.stereotype.Service;

@Service
public class HelperService {

    public Role checkRole(String roleStr) {
        Role role;
        if (roleStr == null || roleStr.isBlank()) {
            role = Role.USER;
        } else {
            try {
                role = Role.valueOf(roleStr.toUpperCase());
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("Invalid role specified");
            }
        }
        return role;
    }
}
