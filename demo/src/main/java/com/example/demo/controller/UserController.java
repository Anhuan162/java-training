package com.example.demo.controller;

import com.example.demo.dto.request.UserCreatedRequest;
import com.example.demo.dto.request.UserUpdatedRequest;
import com.example.demo.dto.response.UserResponse;
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
  ApiResponse<UserResponse> createUser(@RequestBody @Valid UserCreatedRequest userCreatedRequest) {
    ApiResponse<UserResponse> apiResponse = new ApiResponse<>();
    apiResponse.setResult(userService.createUser(userCreatedRequest));
    return apiResponse;
  }

  @GetMapping("/{id}")
  ApiResponse<UserResponse> getUser(@PathVariable String id) {
    return ApiResponse.<UserResponse>builder().result(userService.getUser(id)).build();
  }

  @GetMapping
  ApiResponse<List<UserResponse>> getUsers() {
    return ApiResponse.<List<UserResponse>>builder().result(userService.getUsers()).build();
  }

  @PutMapping("{id}")
  ApiResponse<UserResponse> updateUser(
      @PathVariable String id, @RequestBody UserUpdatedRequest userUpdatedRequest) {
    return ApiResponse.<UserResponse>builder()
        .result(userService.updateUser(userUpdatedRequest, id))
        .build();
  }

  @DeleteMapping("{id}")
  void deleteUser(@PathVariable String id) {
    userService.deleteUser(id);
  }
}
