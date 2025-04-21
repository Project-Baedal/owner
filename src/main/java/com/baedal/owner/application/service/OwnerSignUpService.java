package com.baedal.owner.application.service;

import com.baedal.owner.adapter.out.persistence.entity.OwnerEntity;
import com.baedal.owner.adapter.out.persistence.repository.OwnerJpaRepository;
import com.baedal.owner.application.command.SignupCommand;
import com.baedal.owner.application.command.SignupCommand.Request;
import com.baedal.owner.application.port.in.OwnerSignUpUsecase;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class OwnerSignUpService implements OwnerSignUpUsecase {

  private final OwnerJpaRepository repository;

  private final PasswordEncoder passwordEncoder;

  @Transactional
  public SignupCommand.Response signUp(Request req) {
    OwnerEntity entity = repository.save(new OwnerEntity(
        req.getEmail(),
        req.getName(),
        passwordEncoder.encode(req.getPassword())));

    return SignupCommand.Response.builder()
        .id(entity.getId())
        .build();
  }
}
