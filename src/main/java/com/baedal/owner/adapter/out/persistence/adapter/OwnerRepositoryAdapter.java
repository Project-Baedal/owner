package com.baedal.owner.adapter.out.persistence.adapter;

import com.baedal.owner.adapter.out.persistence.entity.OwnerEntity;
import com.baedal.owner.adapter.out.persistence.manager.OwnerEntityCreator;
import com.baedal.owner.adapter.out.persistence.manager.OwnerEntityReader;
import com.baedal.owner.adapter.out.persistence.mapper.OwnerPersistenceMapper;
import com.baedal.owner.application.port.out.OwnerRepositoryPort;
import com.baedal.owner.domain.model.Owner;
import com.baedal.owner.domain.model.OwnerAuthentication;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OwnerRepositoryAdapter implements OwnerRepositoryPort {

  private final OwnerEntityReader ownerEntityReader;

  private final OwnerEntityCreator ownerEntityCreator;

  private final OwnerPersistenceMapper mapper;

  @Override
  public Owner findById(Long id) {
    OwnerEntity entity = ownerEntityReader.findById(id);
    return mapper.entityToDomain(entity);
  }

  @Override
  public boolean emailAlreadyExist(String email) {
    return ownerEntityReader.emailAlreadyExist(email);
  }

  @Override
  public Long save(String email, String name, String password) {
    OwnerEntity entity = mapper.toEntity(email, name, password);
    return ownerEntityCreator.save(entity)
        .getId();
  }

  @Override
  public OwnerAuthentication findByEmail(String email) {
    OwnerEntity entity = ownerEntityReader.findByEmail(email);
    return mapper.entityToAuthentication(entity);
  }
}
