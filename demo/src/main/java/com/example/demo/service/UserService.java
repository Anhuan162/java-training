package com.example.demo.service;

import com.example.demo.dto.request.UserCreatedRequest;
import com.example.demo.dto.request.UserUpdatedRequest;
import com.example.demo.dto.response.UserResponse;
import com.example.demo.entity.Role;
import com.example.demo.entity.User;
import com.example.demo.exception.AppException;
import com.example.demo.exception.ErrorCode;
import com.example.demo.mapper.UserMapper;
import com.example.demo.repository.UserRepository;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
@Service
@Log4j2
public class UserService {
  @Autowired private UserRepository userRepository;
  @Autowired private UserMapper userMapper;
  @Autowired private PasswordEncoder passwordEncoder;

  public UserResponse createUser(UserCreatedRequest userCreatedRequest) {
    if (userRepository.existsByUsername(userCreatedRequest.getUsername()))
      throw new AppException(ErrorCode.USER_EXISTED);
    User user = userMapper.fromUserCreated(userCreatedRequest);
    user.setPassword(passwordEncoder.encode(userCreatedRequest.getPassword()));

    Set<String> roles = new HashSet<>();
    roles.add(Role.USER.name());

    user.setRoles(roles);
    userRepository.save(user);
    return userMapper.toUserResponse(user);
  }

  public UserResponse getMyInfo() {
    var context = SecurityContextHolder.getContext();
    String name = context.getAuthentication().getName();
    return userMapper.toUserResponse(
            userRepository
                    .findByUsername(name)
                    .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXISTED)));
  }

  @PostAuthorize("returnObject.username = authentication.name")
  public UserResponse getUser(String id) {
    User user =
            userRepository.findById(id).orElseThrow(() -> new RuntimeException("Not found user"));
    return userMapper.toUserResponse(user);
  }

  @PreAuthorize("hasRole('ADMIN')")
  public List<UserResponse> getUsers() {
    log.info("In method getUsers");
    var authorization = SecurityContextHolder.getContext().getAuthentication();
    authorization.getAuthorities().forEach(auth -> log.warn(auth.getAuthority()));

    return userRepository.findAll().stream().map(userMapper::toUserResponse).toList();
  }

  public UserResponse updateUser(UserUpdatedRequest userUpdatedRequest, String id) {
    User user =
            userRepository.findById(id).orElseThrow(() -> new RuntimeException("Not found user"));
    userMapper.updateUser(user, userUpdatedRequest);
    user.setPassword(passwordEncoder.encode(userUpdatedRequest.getPassword()));
    userRepository.save(user);
    return userMapper.toUserResponse(user);
  }

  public void deleteUser(String id) {
    userRepository.deleteById(id);
  }
}
