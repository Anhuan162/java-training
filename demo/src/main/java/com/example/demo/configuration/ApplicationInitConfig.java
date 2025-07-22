package com.example.demo.configuration;

import com.example.demo.entity.Role;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import java.util.HashSet;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ApplicationInitConfig {

  PasswordEncoder passwordEncoder;

  @Bean
  ApplicationRunner applicationRunner(UserRepository userRepository) {
    return args -> {
      if (userRepository.findByUsername("admin").isEmpty()) {
        var roles = new HashSet<String>();
        roles.add(Role.ADMIN.name());

        User user =
            User.builder()
                .username("admin")
                .password(passwordEncoder.encode("adminadmin"))
                .roles(roles)
                .build();

        userRepository.save(user);
      }
    };
  }
}

