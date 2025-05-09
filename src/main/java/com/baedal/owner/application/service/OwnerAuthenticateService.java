package com.baedal.owner.application.service;

import com.baedal.owner.application.command.LoginCommand;
import com.baedal.owner.application.command.SignupCommand;
import com.baedal.owner.application.mapper.OwnerApplicationMapper;
import com.baedal.owner.application.port.in.OwnerAuthenticateUsecase;
import com.baedal.owner.application.port.out.OwnerRepositoryPort;
import com.baedal.owner.domain.model.OwnerAuthentication;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class OwnerAuthenticateService implements OwnerAuthenticateUsecase {

  private final OwnerRepositoryPort ownerRepositoryPort;

  private final PasswordEncoder passwordEncoder;

  private final OwnerApplicationMapper mapper;

  @Transactional(readOnly = true)
  public LoginCommand.Response login(LoginCommand.Request req) {
    OwnerAuthentication auth = ownerRepositoryPort.findByEmail(req.getEmail());

    if (!passwordEncoder.matches(req.getPassword(), auth.getEncryptedPassword())) {
      // FIXME: Define Exception Class
      throw new IllegalArgumentException("Wrong email or password");
    }

    return mapper.toLoginResponse(auth);
  }

  @Transactional
  public SignupCommand.Response signUp(SignupCommand.Request req) {
    Long ownerId = ownerRepositoryPort.save(
        req.getEmail(),
        req.getName(),
        passwordEncoder.encode(req.getPassword()));

    return mapper.toResponse(ownerId);
  }
}
