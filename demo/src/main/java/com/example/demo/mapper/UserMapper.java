package com.example.demo.mapper;

import com.example.demo.dto.request.UserCreatedRequest;
import com.example.demo.dto.request.UserUpdatedRequest;
import com.example.demo.dto.response.UserResponse;
import com.example.demo.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
  User fromUserCreated(UserCreatedRequest userCreatedRequest);
  void updateUser(@MappingTarget User user, UserUpdatedRequest userUpdatedRequest);
  UserResponse toUserResponse(User user);
}
