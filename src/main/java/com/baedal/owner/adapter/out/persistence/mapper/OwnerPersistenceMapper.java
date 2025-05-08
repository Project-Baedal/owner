package com.baedal.owner.adapter.out.persistence.mapper;

import org.mapstruct.Mapper;

import com.baedal.owner.adapter.out.persistence.entity.OwnerEntity;
import com.baedal.owner.domain.model.Owner;

@Mapper(componentModel = "spring")
public interface OwnerPersistenceMapper {

  Owner entityToDomain(OwnerEntity ownerEntity);

  OwnerEntity toEntity(String email, String name, String password);
}
