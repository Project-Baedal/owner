package com.baedal.owner.application.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.baedal.owner.adapter.in.web.dto.command.LoginCommand;
import com.baedal.owner.domain.model.Owner;

@Mapper(componentModel = "spring")
public interface OwnerApplicationMapper {

  // 로그인
  @Mapping(target = "ownerId", source = "id")
  LoginCommand.Response toLoginResponse(Owner owner);

}
