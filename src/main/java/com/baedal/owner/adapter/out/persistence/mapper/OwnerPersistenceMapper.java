package com.baedal.owner.adapter.out.persistence.mapper;

import com.baedal.owner.adapter.out.persistence.entity.OwnerEntity;
import com.baedal.owner.domain.model.Owner;
import com.baedal.owner.domain.model.OwnerAuthentication;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OwnerPersistenceMapper {

  Owner entityToDomain(OwnerEntity ownerEntity);

  OwnerEntity toEntity(String email, String name, String password);

  @Mapping(target = "encryptedPassword", source = "password")
  OwnerAuthentication entityToAuthentication(OwnerEntity entity);
}
