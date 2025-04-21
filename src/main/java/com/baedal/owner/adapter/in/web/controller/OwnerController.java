package com.baedal.owner.adapter.in.web.controller;

import com.baedal.owner.adapter.in.web.dto.request.AddStoreRequest;
import com.baedal.owner.adapter.in.web.dto.request.LoginRequest;
import com.baedal.owner.adapter.in.web.dto.request.SignupRequest;
import com.baedal.owner.adapter.in.web.dto.response.LoginResponse;
import com.baedal.owner.adapter.in.web.mapper.OwnerWebMapper;
import com.baedal.owner.application.command.AddStoreCommand;
import com.baedal.owner.application.command.LoginCommand;
import com.baedal.owner.application.command.SignupCommand;
import com.baedal.owner.application.port.in.OwnerSignupUsecase;
import com.baedal.owner.application.port.in.OwnerUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class OwnerController {

  private final OwnerWebMapper mapper;

  private final OwnerUseCase ownerUseCase;

  private final OwnerSignupUsecase signupUsecase;

  @PostMapping("/v0/login")
  public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest req) {
    LoginCommand.Request command = mapper.loginToCommand(req);
    LoginCommand.Response commandResponse = ownerUseCase.login(command);
    return ResponseEntity.ok(mapper.loginToResponse(commandResponse));
  }

  @PostMapping("/v0/signup")
  public ResponseEntity<?> signup(@RequestBody SignupRequest request) {
    SignupCommand.Request command = mapper.signupToCommand(request);
    SignupCommand.Response commandResponse = signupUsecase.signup(command);
    return ResponseEntity.ok(mapper.signupToResponse(commandResponse));
  }

  @PostMapping("/v0/addStore")
  public ResponseEntity<Void> addStore(
      Authentication authentication,
      @RequestBody AddStoreRequest req) {
    AddStoreCommand.Request command = mapper.addStoreToCommand(req);
    // note. 인증 관련 코드 작성 이후 변경 예정
    Long ownerId = 1L;
    ownerUseCase.addStore(ownerId, command);
    return ResponseEntity.noContent().build();
  }

  @GetMapping("/v0/auth-example")
  public ResponseEntity<Void> example(Authentication authentication) {
    log.debug("principal={}", authentication.getPrincipal().toString());
    log.debug("name={}", authentication.getName());
    log.debug("Authorities={}", authentication.getAuthorities().toString());
    return ResponseEntity.noContent().build();
  }
}
