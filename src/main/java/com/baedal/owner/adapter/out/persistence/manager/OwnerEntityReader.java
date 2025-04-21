package com.baedal.owner.adapter.out.persistence.manager;

import org.springframework.stereotype.Component;

import com.baedal.owner.adapter.out.persistence.entity.OwnerEntity;
import com.baedal.owner.adapter.out.persistence.repository.OwnerJpaRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class OwnerEntityReader {

  private final OwnerJpaRepository ownerJpaRepository;

  // FIXME: 비밀번호는 조회와 함께 사용할 수 없음
  public OwnerEntity findByAccountAndPassword(String account, String password) {
    return ownerJpaRepository.findByEmail(account)
        .orElseThrow(() -> new RuntimeException("잘못된 아이디/비밀번호 입니다."));
  }

  public OwnerEntity findById(Long id) {
    return ownerJpaRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("존재하지 않거나 접근 권한이 없는 점주입니다."));
  }
}
