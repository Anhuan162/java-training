package com.example.demo.dto.request;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Value;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Value
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserUpdatedRequest {
  String password;
  String firstName;
  String lastName;
  String email;
  Date dob;
}
