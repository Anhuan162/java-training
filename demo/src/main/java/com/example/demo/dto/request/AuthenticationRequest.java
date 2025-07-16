package com.example.demo.dto.request;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class AuthenticationRequest {
  String username;
  String password;
}
