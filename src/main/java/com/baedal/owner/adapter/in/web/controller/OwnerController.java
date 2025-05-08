package com.baedal.owner.adapter.in.web.controller;

import com.baedal.owner.adapter.in.web.dto.request.AddStoreRequest;
import com.baedal.owner.adapter.in.web.dto.request.LoginRequest;
import com.baedal.owner.adapter.in.web.dto.request.SignUpRequest;
import com.baedal.owner.adapter.in.web.dto.response.LoginResponse;
import com.baedal.owner.adapter.in.web.dto.response.SignUpResponse;
import com.baedal.owner.adapter.in.web.mapper.OwnerWebMapper;
import com.baedal.owner.application.command.AddStoreCommand;
import com.baedal.owner.application.command.LoginCommand;
import com.baedal.owner.application.command.SignupCommand;
import com.baedal.owner.application.port.in.OwnerAuthenticateUsecase;
import com.baedal.owner.application.port.in.OwnerUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/owner/v0")
public class OwnerController {

  private final OwnerWebMapper mapper;

  private final OwnerUseCase ownerUseCase;

  private final OwnerAuthenticateUsecase authenticateUsecase;

  @PostMapping("/login")
  public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest req) {
    LoginCommand.Request command = mapper.loginToCommand(req);
    LoginCommand.Response commandResponse = authenticateUsecase.login(command);
    return ResponseEntity.ok(mapper.loginToResponse(commandResponse));
  }

  @PostMapping("/signup")
  public ResponseEntity<SignUpResponse> signUp(@RequestBody SignUpRequest request) {
    SignupCommand.Request command = mapper.signupToCommand(request);
    SignupCommand.Response commandResponse = authenticateUsecase.signUp(command);
    return ResponseEntity.ok(mapper.signupToResponse(commandResponse));
  }

  @PreAuthorize("hasRole('OWNER')")
  @PostMapping("/addStore")
  public ResponseEntity<Void> addStore(
      @RequestBody AddStoreRequest req,
      @AuthenticationPrincipal Long ownerId) {
    AddStoreCommand.Request command = mapper.addStoreToCommand(req);
    ownerUseCase.addStore(ownerId, command);
    return ResponseEntity.noContent().build();
  }
}
