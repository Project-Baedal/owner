package com.baedal.owner.adapter.in.web.mapper;

import org.mapstruct.Mapper;

import com.baedal.owner.application.command.LoginCommand;
import com.baedal.owner.adapter.in.web.dto.request.LoginRequest;
import com.baedal.owner.adapter.in.web.dto.response.LoginResponse;

@Mapper(componentModel = "spring")
public interface OwnerWebMapper {

  // 로그인
  LoginCommand.Request loginToCommand(LoginRequest loginRequest);
  LoginResponse loginToResponse(LoginCommand.Response loginCommand);
}
