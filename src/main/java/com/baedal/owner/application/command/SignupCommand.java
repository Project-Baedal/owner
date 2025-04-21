package com.baedal.owner.application.command;

import lombok.Builder;
import lombok.Getter;

public class SignupCommand {

  @Getter
  @Builder
  public static class Request {

    String email;
    String name;
    String password;
  }

  @Getter
  @Builder
  public static class Response {

    Long id;
  }
}
