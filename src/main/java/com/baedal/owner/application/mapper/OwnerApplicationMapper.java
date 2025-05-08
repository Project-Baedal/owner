package com.baedal.owner.application.mapper;

import com.baedal.owner.application.command.LoginCommand;
import com.baedal.owner.application.command.SignupCommand;
import com.baedal.owner.domain.model.OwnerAuthentication;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OwnerApplicationMapper {

  // 로그인
  LoginCommand.Response toLoginResponse(OwnerAuthentication owner);

  SignupCommand.Response toResponse(Long id);
}
