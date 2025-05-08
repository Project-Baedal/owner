package com.baedal.owner.adapter.out.persistence.manager;

import com.baedal.owner.adapter.out.persistence.entity.OwnerEntity;
import com.baedal.owner.adapter.out.persistence.repository.OwnerJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OwnerEntityReader {

  private final OwnerJpaRepository ownerJpaRepository;

  public OwnerEntity findByEmail(String email) {
    return ownerJpaRepository.findByEmail(email)
        .orElseThrow(() -> new RuntimeException("잘못된 아이디/비밀번호 입니다."));
  }

  public Boolean emailAlreadyExist(String email) {
    return ownerJpaRepository.findByEmail(email).isPresent();
  }

  public OwnerEntity findById(Long id) {
    return ownerJpaRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("존재하지 않거나 접근 권한이 없는 점주입니다."));
  }
}
