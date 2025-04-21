package com.baedal.owner.application.command;

import lombok.Builder;
import lombok.Getter;

public class LoginCommand {

  @Getter
  @Builder
  public static class Request {

    private String email;
    private String password;
  }

  @Getter
  @Builder
  public static class Response {

    private Long id;
  }
}
