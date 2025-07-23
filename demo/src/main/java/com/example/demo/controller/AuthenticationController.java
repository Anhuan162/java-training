package com.example.demo.controller;

import com.huan.identity_service.dto.request.AuthenticationRequest;
import com.huan.identity_service.dto.response.AuthenticationResponse;
import com.huan.identity_service.exception.ApiResponse;
import com.huan.identity_service.service.AuthenticationService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthenticationController {
  AuthenticationService authenticationService;

  @PostMapping("log-in")
  ApiResponse<AuthenticationResponse> authenticate(
      @RequestBody AuthenticationRequest authenticationRequest) {
    var result = authenticationService.authenticate(authenticationRequest);

    return ApiResponse.<AuthenticationResponse>builder().result(result).build();
  }
}
