package com.taskManagement.user_service.service;

import com.taskManagement.user_service.dtos.AuthResponse;
import com.taskManagement.user_service.dtos.LoginRequestDTO;
import com.taskManagement.user_service.dtos.RegisterRequestDTO;
import com.taskManagement.user_service.entity.User;
import com.taskManagement.user_service.enums.Role;
import com.taskManagement.user_service.exception.InvalidCredentialsException;
import com.taskManagement.user_service.exception.UserAlreadyExistsException;
import com.taskManagement.user_service.interfaces.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserService userService;
    private final HelperService helperService;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    @Override
    public AuthResponse login(LoginRequestDTO request) {
        User user = userService.getUserByEmail(request.getEmail())
                .orElseThrow(() -> new UsernameNotFoundException("Invalid email!"));

        if(!passwordEncoder.matches(request.getPassword(), user.getPassword())){
            throw new InvalidCredentialsException("Wrong password!");
        }
        return new AuthResponse(jwtService.generateToken(user));
    }

    @Override
    public AuthResponse register(RegisterRequestDTO user) {
        if(userService.getUserByEmail(user.getEmail()).isPresent()){
            throw new UserAlreadyExistsException("This email already exists!");
        }
        Role role = helperService.checkRole(user.getRole());
        User createUser =  User.builder()
                .email(user.getEmail())
                .password(passwordEncoder.encode(user.getPassword()))
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .role(role)
                .country(user.getCountry())
                .build();
        User created = userService.saveUser(createUser);

        return new AuthResponse(jwtService.generateToken(created));
    }
}
