package com.baedal.owner.adapter.in.web.controller;

import com.baedal.owner.adapter.in.web.dto.request.LoginRequest;
import com.baedal.owner.adapter.in.web.dto.request.SignUpRequest;
import com.baedal.owner.adapter.in.web.dto.response.LoginResponse;
import com.baedal.owner.adapter.in.web.dto.response.SignUpResponse;
import com.baedal.owner.adapter.in.web.mapper.OwnerWebMapper;
import com.baedal.owner.application.command.LoginCommand;
import com.baedal.owner.application.command.SignupCommand;
import com.baedal.owner.application.port.in.OwnerAuthenticateUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/owner/public")
public class OwnerAuthenticateController {

  private final OwnerWebMapper mapper;

  private final OwnerAuthenticateUseCase authenticateUseCase;

  @PostMapping("/v0/login")
  public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest req) {
    LoginCommand.Request command = mapper.loginToCommand(req);
    LoginCommand.Response commandResponse = authenticateUseCase.login(command);
    return ResponseEntity.ok(mapper.loginToResponse(commandResponse));
  }

  @PostMapping("/v0/signup")
  public ResponseEntity<SignUpResponse> signUp(@RequestBody SignUpRequest request) {
    SignupCommand.Request command = mapper.signupToCommand(request);
    SignupCommand.Response commandResponse = authenticateUseCase.signUp(command);
    return ResponseEntity.ok(mapper.signupToResponse(commandResponse));
  }
}
