package com.baedal.owner.adapter.in.web.dto.request;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class LoginRequest {

  private String email;
  private String password;

}
