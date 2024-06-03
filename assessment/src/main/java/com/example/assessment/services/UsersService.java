package com.example.assessment.services;

import org.springframework.data.domain.Page;

import com.example.assessment.dao.Users;
import com.example.assessment.dto.request.RegisterRequest;
import com.example.assessment.dto.request.UpdateUserRequest;
import com.example.assessment.dto.response.GetSingleUserResponse;
import com.example.assessment.dto.response.RegisterResponse;
import com.example.assessment.dto.response.UpdateUserResponse;

public interface UsersService {
    public Page<Users> getAllUsers(int pageNo, int pageSize);
    public RegisterResponse addUser(RegisterRequest request);
    public GetSingleUserResponse getUserById(int id);
    public UpdateUserResponse updateUserById(int id, UpdateUserRequest request);
}
