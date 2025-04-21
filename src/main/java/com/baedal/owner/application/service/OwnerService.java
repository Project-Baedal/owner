package com.baedal.owner.application.service;

import com.baedal.owner.application.command.AddStoreCommand;
import com.baedal.owner.application.command.LoginCommand;
import com.baedal.owner.application.mapper.OwnerApplicationMapper;
import com.baedal.owner.application.port.in.OwnerUseCase;
import com.baedal.owner.application.port.out.MessageSenderPort;
import com.baedal.owner.application.port.out.OwnerRepositoryPort;
import com.baedal.owner.application.service.UserDetailServiceImpl.UserDetailsImpl;
import com.baedal.owner.domain.model.Owner;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class OwnerService implements OwnerUseCase {

  private final OwnerRepositoryPort repositoryPort;

  private final OwnerApplicationMapper mapper;

  private final MessageSenderPort messageSenderPort;

  private final UserDetailsService userDetailsService;

  private final PasswordEncoder passwordEncoder;

  @Override
  @Transactional(readOnly = true)
  public LoginCommand.Response login(LoginCommand.Request req) {
    UserDetailsImpl user = (UserDetailsImpl) userDetailsService.loadUserByUsername(req.getEmail());

    if (!passwordEncoder.matches(req.getPassword(), user.getPassword())) {
      // FIXME: Define Exception Class
      throw new IllegalArgumentException("Invalid email or password");
    }

    Owner owner = Owner.builder()
        .id(user.owner().getId())
        .build();
    return mapper.toLoginResponse(owner);
  }

  @Override
  @Transactional(readOnly = true)
  public void addStore(Long ownerId, AddStoreCommand.Request req) {
    repositoryPort.findById(ownerId);
    messageSenderPort.sendAddStore(ownerId, req);
  }
}
