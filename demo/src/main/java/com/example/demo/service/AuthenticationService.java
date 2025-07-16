package com.example.demo.service;

import com.example.demo.dto.request.AuthenticationRequest;
import com.example.demo.dto.response.AuthenticationResponse;
import com.example.demo.entity.User;
import com.example.demo.exception.AppException;
import com.example.demo.exception.ErrorCode;
import com.example.demo.repository.UserRepository;
import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jwt.JWTClaimsSet;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthenticationService {

  UserRepository userRepository;
  protected static final String SIGNED_KEY =
      "EZlMr8WycQGUTx8N3Fra8NZXY33tDbCOXv40rJ2DCAsMYDlOfP7s46+/E6ksRIeD";

  public AuthenticationResponse authenticate(AuthenticationRequest request) {
    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    User user = userRepository.findByUsername(request.getUsername());

    boolean authenticate = passwordEncoder.matches(request.getPassword(), user.getPassword());

    if (!authenticate) {
      throw new AppException(ErrorCode.UNAUTHENTICATED);
    }

    String token = generateToken(request.getUsername());
    return AuthenticationResponse.builder().authenticated(true).token(token).build();
  }

  String generateToken(String username) {
    JWSHeader header = new JWSHeader(JWSAlgorithm.HS512);

    JWTClaimsSet jwtClaimsSet =
        new JWTClaimsSet.Builder()
            .subject(username)
            .issuer("huanmu.com")
            .issueTime(new Date())
            .expirationTime(new Date(Instant.now().plus(1, ChronoUnit.HOURS).toEpochMilli()))
            .build();

    Payload payload = new Payload(jwtClaimsSet.toJSONObject());
    JWSObject jsonObject = new JWSObject(header, payload);

    try {
      jsonObject.sign(new MACSigner(SIGNED_KEY.getBytes()));
      return jsonObject.serialize();
    } catch (JOSEException e) {
      log.error("Can not create exception");
      throw new RuntimeException(e);
    }
  }
}
