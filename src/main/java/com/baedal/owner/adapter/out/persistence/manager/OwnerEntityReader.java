package com.baedal.owner.adapter.out.persistence.manager;

import org.springframework.stereotype.Component;

import com.baedal.owner.adapter.out.persistence.entity.OwnerEntity;
import com.baedal.owner.adapter.out.persistence.repository.OwnerJpaRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class OwnerEntityReader {

	private final OwnerJpaRepository ownerJpaRepository;

	public OwnerEntity findByAccountAndPassword(String account, String password) {
		return ownerJpaRepository.findByAccountAndPassword(account, password)
			.orElseThrow(RuntimeException::new);
	}

}
