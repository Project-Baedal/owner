package com.baedal.owner.adapter.out.persistence.manager;

import com.baedal.owner.adapter.out.persistence.entity.OwnerEntity;
import com.baedal.owner.adapter.out.persistence.repository.OwnerJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OwnerEntityCreator {

  private final OwnerJpaRepository repository;

  public OwnerEntity save(String email, String name, String password) {
    return repository.save(OwnerEntity.builder()
        .email(email)
        .name(name)
        .password(password)
        .build());
  }
}
