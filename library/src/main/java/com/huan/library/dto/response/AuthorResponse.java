package com.huan.library.dto.response;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class AuthorResponse {
    int id;
    String name;
}
