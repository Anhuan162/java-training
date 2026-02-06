package com.example.demo.service;

import com.example.demo.dto.request.AuthenticationRequest;
import com.example.demo.dto.request.IntrospectRequest;
import com.example.demo.dto.response.AuthenticationResponse;
import com.example.demo.dto.response.IntrospectResponse;
import com.example.demo.entity.User;
import com.example.demo.exception.AppException;
import com.example.demo.exception.ErrorCode;
import com.example.demo.repository.UserRepository;
import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.MACVerifier;
import com.nimbusds.jwt.JWTClaimsSet;

import java.text.ParseException;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import com.nimbusds.jwt.SignedJWT;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthenticationService {

  UserRepository userRepository;

  @NonFinal
  @Value("${jwt.signerKey}")
  protected String SIGNER_KEY;

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
      jsonObject.sign(new MACSigner(SIGNER_KEY.getBytes()));
      return jsonObject.serialize();
    } catch (JOSEException e) {
      log.error("Can not create exception");
      throw new RuntimeException(e);
    }
  }

  public IntrospectResponse introspect(IntrospectRequest introspectRequest)
          throws JOSEException, ParseException {
    var token = introspectRequest.getToken();

    JWSVerifier verifier = new MACVerifier(SIGNER_KEY);
    SignedJWT signedJWT = SignedJWT.parse(token);

    Date experationTime = signedJWT.getJWTClaimsSet().getExpirationTime();
    var verified = signedJWT.verify(verifier);

    return IntrospectResponse.builder().valid(verified && experationTime.after(new Date())).build();
  }
}
