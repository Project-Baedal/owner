package com.baedal.owner.application.service;

import com.baedal.owner.adapter.out.persistence.entity.OwnerEntity;
import com.baedal.owner.adapter.out.persistence.repository.OwnerJpaRepository;
import com.baedal.owner.application.command.LoginCommand;
import com.baedal.owner.application.command.SignupCommand;
import com.baedal.owner.application.command.SignupCommand.Request;
import com.baedal.owner.application.mapper.OwnerApplicationMapper;
import com.baedal.owner.application.port.in.OwnerAuthenticateUsecase;
import com.baedal.owner.application.service.UserDetailServiceImpl.UserDetailsImpl;
import com.baedal.owner.domain.model.Owner;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class OwnerAuthenticateService implements OwnerAuthenticateUsecase {

  private final UserDetailsService userDetailsService;

  private final OwnerJpaRepository repository;

  private final OwnerApplicationMapper mapper;

  private final PasswordEncoder passwordEncoder;

  @Transactional(readOnly = true)
  public LoginCommand.Response login(LoginCommand.Request req) {
    UserDetailsImpl user = (UserDetailsImpl) userDetailsService.loadUserByUsername(req.getEmail());

    if (!passwordEncoder.matches(req.getPassword(), user.getPassword())) {
      // FIXME: Define Exception Class
      throw new IllegalArgumentException("Invalid email or password");
    }

    Owner owner = mapper.userDetailsToDomain(user);
    return mapper.toLoginResponse(owner);
  }

  @Transactional
  public SignupCommand.Response signUp(Request req) {
    OwnerEntity entity = repository.save(new OwnerEntity(
        req.getEmail(),
        req.getName(),
        passwordEncoder.encode(req.getPassword())));

    return SignupCommand.Response.builder()
        .id(entity.getId())
        .build();
  }
}
