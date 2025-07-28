package com.huan.library.dto.request;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class AuthorRequest {
  String name;
}
