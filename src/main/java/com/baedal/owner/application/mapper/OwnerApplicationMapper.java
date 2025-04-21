package com.baedal.owner.application.mapper;

import com.baedal.owner.application.command.LoginCommand;
import com.baedal.owner.domain.model.Owner;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OwnerApplicationMapper {

  // 로그인
  LoginCommand.Response toLoginResponse(Owner owner);
}
