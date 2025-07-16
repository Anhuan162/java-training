package com.example.demo.dto.request;

import com.example.demo.entity.User;
import java.util.Date;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Value
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserCreatedRequest {
    String username;
    String password;
    String firstName;
    String lastName;
    String email;
    Date dob;
}
