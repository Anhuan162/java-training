package com.example.demo.controller;

import com.example.demo.dto.request.UserCreatedRequest;
import com.example.demo.dto.request.UserUpdatedRequest;
import com.example.demo.entity.User;
import com.example.demo.exception.ApiResponse;
import com.example.demo.service.UserService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
  @Autowired private UserService userService;

  @PostMapping
  ApiResponse<User> createUser(@RequestBody @Valid UserCreatedRequest userCreatedRequest) {
    ApiResponse<User> apiResponse = new ApiResponse<>();
    apiResponse.setResult(userService.createUser(userCreatedRequest));
    return apiResponse;
  }

  @GetMapping("/{id}")
  User getUser(@PathVariable String id) {
    return userService.getUser(id);
  }

  @GetMapping
  List<User> getUsers() {
    return userService.getUsers();
  }

  @PutMapping("{id}")
  User updateUser(@PathVariable String id, @RequestBody UserUpdatedRequest userUpdatedRequest) {
    return userService.updateUser(userUpdatedRequest, id);
  }

  @DeleteMapping("{id}")
  void deleteUser(@PathVariable String id) {
    userService.deleteUser(id);
  }
}
