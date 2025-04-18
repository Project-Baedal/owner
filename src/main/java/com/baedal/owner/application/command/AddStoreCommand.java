package com.baedal.owner.application.command;

import java.time.LocalTime;
import lombok.Builder;
import lombok.Getter;

public class AddStoreCommand {

  @Getter
  @Builder
  public static class Request {

    private String title;
    private String content;
    private String category;
    private String name;
    private String address;
    private String pictureUrl;
    private LocalTime openTime;
    private LocalTime closeTime;
    private int deliveryAmount;
  }

}
