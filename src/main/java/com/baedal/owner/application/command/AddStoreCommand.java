package com.baedal.owner.application.command;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Getter;

public class AddStoreCommand {

  @Getter
  @Builder
  public static class Request {
    private String name;
    private String address;
    private String pictureUrl;
    private LocalDateTime openTime;
    private LocalDateTime closeTime;
  }

}
