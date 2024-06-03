package com.example.assessment.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;

import com.example.assessment.dao.Users;
import com.example.assessment.dto.request.RegisterRequest;
import com.example.assessment.dto.request.UpdateUserRequest;
import com.example.assessment.dto.response.GetSingleUserResponse;
import com.example.assessment.dto.response.RegisterResponse;
import com.example.assessment.dto.response.UpdateUserResponse;
import com.example.assessment.services.UsersService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/users")
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UsersService usersService;

    @GetMapping
    public Page<Users> getUsers(@RequestParam(defaultValue = "0") int pageNo, @RequestParam(defaultValue = "10") int pageSize) {
        return usersService.getAllUsers(pageNo, pageSize);
    }

    @PostMapping("/add")
    public ResponseEntity<RegisterResponse> addUser(@RequestBody RegisterRequest request) {
        log.info("Register API Request : {} ", request);
        return ResponseEntity.ok(usersService.addUser(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetSingleUserResponse> getUserById(@PathVariable int id) {
        GetSingleUserResponse response = usersService.getUserById(id);

        if (response.getUserId() != null) {
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    @PostMapping("/{id}")
    public ResponseEntity<UpdateUserResponse> updateUserById(@PathVariable int id, @RequestBody UpdateUserRequest request) {
        log.info("Update User Request : {} ", request);
        UpdateUserResponse response = usersService.updateUserById(id, request);

        if (response.getUserId() != null) {
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }
}
