package com.example.demo.dto.response;


import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class AuthenticationResponse {
    String token;
    boolean authenticated;
}
