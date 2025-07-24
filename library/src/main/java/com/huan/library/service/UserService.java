package com.huan.library.service;

import com.huan.library.dto.request.UserRequest;
import com.huan.library.dto.response.UserResponse;
import com.huan.library.entity.User;
import com.huan.library.repository.UserRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
  private final UserRepository userRepository;

  public UserResponse createUser(UserRequest request) {
    User user = new User();
    user.setName(request.getName());
    user.setRole(request.getRole());
    user.setEmail(request.getEmail());

    User saved = userRepository.save(user);
    return mapToResponse(saved);
  }

  public List<UserResponse> getAllUsers() {
    return userRepository.findAll().stream().map(this::mapToResponse).collect(Collectors.toList());
  }

  public UserResponse getUserById(int id) {
    User user =
        userRepository
            .findById(id)
            .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    return mapToResponse(user);
  }

  private UserResponse mapToResponse(User user) {
    return UserResponse.builder()
        .id(user.getUserId())
        .name(user.getName())
        .role(user.getRole())
        .email(user.getEmail())
        .build();
  }
}
