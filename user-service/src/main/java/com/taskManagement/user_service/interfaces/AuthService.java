package com.taskManagement.user_service.interfaces;

import com.taskManagement.user_service.dtos.AuthResponse;
import com.taskManagement.user_service.dtos.LoginRequestDTO;
import com.taskManagement.user_service.dtos.RegisterRequestDTO;

public interface AuthService {

     AuthResponse login(LoginRequestDTO request);
     AuthResponse register(RegisterRequestDTO user);
}
