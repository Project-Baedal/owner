package com.baedal.owner.adapter.in.web.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baedal.owner.adapter.in.web.dto.request.AddStoreRequest;
import com.baedal.owner.application.command.AddStoreCommand;
import com.baedal.owner.application.command.LoginCommand;
import com.baedal.owner.adapter.in.web.dto.request.LoginRequest;
import com.baedal.owner.adapter.in.web.dto.response.LoginResponse;
import com.baedal.owner.adapter.in.web.mapper.OwnerWebMapper;
import com.baedal.owner.application.port.in.OwnerUseCase;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/owner")
@RequiredArgsConstructor
public class OwnerController {

  private final OwnerWebMapper mapper;
  private final OwnerUseCase ownerUseCase;

  @PostMapping("/login")
  public LoginResponse login(@RequestBody LoginRequest req) {
    LoginCommand.Request command = mapper.loginToCommand(req);
    LoginCommand.Response response = ownerUseCase.login(command);
    return mapper.loginToResponse(response);
  }

  @PostMapping("/addStore")
  public void addStore(@RequestBody AddStoreRequest req) {
    AddStoreCommand.Request command = mapper.addStoreToCommand(req);
    // note. 인증 관련 코드 작성 이후 변경 예정
    Long ownerId = 1L;
    ownerUseCase.addStore(ownerId, command);
  }
}
