package com.baedal.owner.adapter.in.web.dto.command;

import lombok.Builder;
import lombok.Getter;

public class LoginCommand {

  @Getter
  @Builder
  public static class Request {
    private String account;
    private String password;
  }

  @Getter
  @Builder
  public static class Response {
    private Long ownerId;
  }
}
