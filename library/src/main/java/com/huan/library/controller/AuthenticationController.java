package com.huan.library.controller;

import com.huan.library.dto.request.AuthenticationRequest;
import com.huan.library.dto.request.IntrospectRequest;
import com.huan.library.dto.response.ApiResponse;
import com.huan.library.dto.response.AuthenticationResponse;
import com.huan.library.dto.response.IntrospectResponse;
import com.huan.library.service.AuthenticationService;
import com.nimbusds.jose.JOSEException;
import java.text.ParseException;
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

  @PostMapping("token")
  ApiResponse<AuthenticationResponse> authenticate(
      @RequestBody AuthenticationRequest authenticationRequest) {
    var result = authenticationService.authenticate(authenticationRequest);

    return ApiResponse.<AuthenticationResponse>builder().result(result).build();
  }

  @PostMapping("introspect")
  ApiResponse<IntrospectResponse> introspect(@RequestBody IntrospectRequest introspectRequest)
      throws JOSEException, ParseException {
    var result = authenticationService.introspect(introspectRequest);
    return ApiResponse.<IntrospectResponse>builder().result(result).build();
  }
}
