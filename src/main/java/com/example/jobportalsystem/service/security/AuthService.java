package com.example.jobportalsystem.service.security;

import com.example.jobportalsystem.dto.security.AuthResponse;
import com.example.jobportalsystem.dto.security.LoginDTO;
import com.example.jobportalsystem.dto.security.RegisterDTO;

public interface AuthService {
    AuthResponse register(RegisterDTO request);
    AuthResponse login(LoginDTO request);


}
