package com.example.demo.service;

import com.example.demo.dto.request.UserCreatedRequest;
import com.example.demo.dto.request.UserUpdatedRequest;
import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.repository.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
  @Autowired private UserRepository userRepository;
  @Autowired private UserMapper userMapper;

  public User createUser(UserCreatedRequest userCreatedRequest) {
    User user = userMapper.fromUserCreated(userCreatedRequest);

    return userRepository.save(user);
  }

  public User getUser(String id) {
    return userRepository.findById(id).orElseThrow(() -> new RuntimeException("Not found user"));
  }

  public List<User> getUsers() {
    return userRepository.findAll();
  }

  public User updateUser(UserUpdatedRequest userUpdatedRequest, String id) {
    User user = getUser(id);
    userMapper.updateUser(user, userUpdatedRequest);
    return userRepository.save(user);
  }

  public void deleteUser(String id) {
    userRepository.deleteById(id);
  }
}
