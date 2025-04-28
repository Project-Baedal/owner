package com.baedal.owner.application.mapper;

import com.baedal.owner.application.command.LoginCommand;
import com.baedal.owner.application.service.UserDetailServiceImpl.UserDetailsImpl;
import com.baedal.owner.domain.model.Owner;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OwnerApplicationMapper {

  // 로그인
  LoginCommand.Response toLoginResponse(Owner owner);

  @Mapping(target = "id", source = "u.owner.id")
  Owner userDetailsToDomain(UserDetailsImpl u);
}
