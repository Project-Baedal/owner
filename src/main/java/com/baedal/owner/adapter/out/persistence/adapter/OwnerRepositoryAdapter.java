package com.baedal.owner.adapter.out.persistence.adapter;

import org.springframework.stereotype.Component;

import com.baedal.owner.adapter.out.persistence.entity.OwnerEntity;
import com.baedal.owner.adapter.out.persistence.manager.OwnerEntityReader;
import com.baedal.owner.adapter.out.persistence.mapper.OwnerPersistenceMapper;
import com.baedal.owner.application.port.out.OwnerRepositoryPort;
import com.baedal.owner.domain.model.Owner;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class OwnerRepositoryAdapter implements OwnerRepositoryPort {

	private final OwnerEntityReader ownerEntityReader;
	private final OwnerPersistenceMapper mapper;

	@Override
	public Owner findActiveUserByAccountAndPassword(String account, String password) {
		OwnerEntity entity = ownerEntityReader.findByAccountAndPassword(account, password);
		return mapper.entityToDomain(entity);
	}

}
