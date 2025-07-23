package com.example.demo.dto.request.request;

import com.huan.identity_service.entity.User;
import jakarta.validation.constraints.Size;
import java.util.Date;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Value
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserCreatedRequest {
    @Size(min = 4, message = "USERNAME_INVALID")
    String username;
    @Size(min = 8, message = "PASSWORD_INVALID")
    String password;
    String firstName;
    String lastName;
    String email;
    Date dob;

    public User toUser() {
        return User.builder()
                .username(username)
                .password(password)
                .firstName(firstName)
                .lastName(lastName)
                .email(email)
                .dob(dob)
                .build();
    }

}
