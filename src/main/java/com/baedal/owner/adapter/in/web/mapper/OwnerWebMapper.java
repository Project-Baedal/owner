package com.baedal.owner.adapter.in.web.mapper;

import com.baedal.owner.adapter.in.web.dto.request.AddStoreRequest;
import com.baedal.owner.adapter.in.web.dto.request.LoginRequest;
import com.baedal.owner.adapter.in.web.dto.request.SignUpRequest;
import com.baedal.owner.adapter.in.web.dto.response.LoginResponse;
import com.baedal.owner.adapter.in.web.dto.response.SignUpResponse;
import com.baedal.owner.application.command.AddStoreCommand;
import com.baedal.owner.application.command.LoginCommand;
import com.baedal.owner.application.command.SignupCommand;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OwnerWebMapper {

  // 로그인
  LoginCommand.Request loginToCommand(LoginRequest loginRequest);

  LoginResponse loginToResponse(LoginCommand.Response loginCommand);

  // 매장 추가
  AddStoreCommand.Request addStoreToCommand(AddStoreRequest addStoreRequest);

  // 가입
  SignupCommand.Request signupToCommand(SignUpRequest request);

  SignUpResponse signupToResponse(SignupCommand.Response signupCommand);
}
