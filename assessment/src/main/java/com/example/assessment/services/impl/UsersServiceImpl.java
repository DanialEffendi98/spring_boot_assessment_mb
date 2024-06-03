package com.example.assessment.services.impl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.assessment.dao.Users;
import com.example.assessment.dao.repo.UsersRepo;
import com.example.assessment.dto.request.RegisterRequest;
import com.example.assessment.dto.request.UpdateUserRequest;
import com.example.assessment.dto.response.GetSingleUserResponse;
import com.example.assessment.dto.response.RegisterResponse;
import com.example.assessment.dto.response.UpdateUserResponse;
import com.example.assessment.services.UsersService;

@Service
public class UsersServiceImpl implements UsersService{

    @Autowired
    private UsersRepo usersRepo;
    
    private static final Logger log = LoggerFactory.getLogger(UsersServiceImpl.class);

    @Transactional(readOnly = true)
    public Page<Users> getAllUsers(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<Users> userList = usersRepo.findAll(pageable);

        log.info("Get All Users With Pagination API Response : {}", userList);
        return userList;
    }

    @Transactional
    public RegisterResponse addUser(RegisterRequest request) {

        RegisterResponse response = new RegisterResponse();

        if (usersRepo.findByUserId(request.getUserId()).isPresent() || usersRepo.findByEmail(request.getEmail()).isPresent()) {
            response.setUserId(request.getUserId());
            response.setMessage("User ID or email already exists!");
            return response;
        }

        // Check if email and location are not null or empty
        if (request.getUserId() == null || request.getUserId().isEmpty() ||
            request.getEmail() == null || request.getEmail().isEmpty()) {
            response.setMessage("User ID and email are required fields!");
            return response;
        }

        Users user = new Users();
        user.setUserId(request.getUserId());
        user.setEmail(request.getEmail());
        user.setLocation(request.getLocation());
        usersRepo.save(user);

        log.info("Register API Response : {}", response);

        response.setUserId(user.getUserId());
        response.setMessage("User " + user.getUserId() + " created successfully!");
        return response;
    }

    @Transactional(readOnly = true)
    public GetSingleUserResponse getUserById(int id) {
        GetSingleUserResponse response = new GetSingleUserResponse();

        Optional<Users> user = usersRepo.findById(id);
        if (user.isPresent()) {
            Users currentUser = user.get();

            response.setUserId(currentUser.getUserId());
            response.setEmail(currentUser.getEmail());
            response.setLocation(currentUser.getLocation());
            response.setMessage("User found successfully.");
        } else {
            response.setMessage("User not found");
        }
        log.info("Get Single User Response : {}", response);

        return response;
    }

    @Transactional
    public UpdateUserResponse updateUserById(int id, UpdateUserRequest request) {
        UpdateUserResponse response = new UpdateUserResponse();

        // Check if the provided user ID already exists for another user
        Optional<Users> userWithSameId = usersRepo.findByUserIdAndIdNot(request.getUserId(), id);
        if (userWithSameId.isPresent()) {
            response.setMessage("User ID " + request.getUserId() + "already exists for another user");
            return response;
        }

        // Check if the provided email already exists for another user
        Optional<Users> userWithSameEmail = usersRepo.findByEmailAndIdNot(request.getEmail(), id);
        if (userWithSameEmail.isPresent()) {
            response.setMessage("Email " + request.getEmail() + " already exists for another user");
            return response;
        }

        // Retrieve the user by ID
        Optional<Users> user = usersRepo.findById(id);
        if (user.isPresent()) {
            Users currentUser = user.get();

            currentUser.setUserId(request.getUserId());
            currentUser.setEmail(request.getEmail());
            usersRepo.save(currentUser);

            response.setUserId(currentUser.getUserId());
            response.setMessage("User updated successfully!");
        } else {
            response.setMessage("User not found");
        }
        log.info("Update User Details Response : {} ", response);

        return response;
    }
}
