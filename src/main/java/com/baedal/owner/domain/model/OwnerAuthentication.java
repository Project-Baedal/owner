package com.baedal.owner.domain.model;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class OwnerAuthentication {

  private Long id;

  private String email;

  private String encryptedPassword;
}
