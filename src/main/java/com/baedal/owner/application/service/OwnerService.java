package com.baedal.owner.application.service;

import com.baedal.owner.application.command.AddStoreCommand;
import com.baedal.owner.application.port.in.OwnerUseCase;
import com.baedal.owner.application.port.out.MessageSenderPort;
import com.baedal.owner.application.port.out.OwnerRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class OwnerService implements OwnerUseCase {

  private final OwnerRepositoryPort repositoryPort;

  private final MessageSenderPort messageSenderPort;

  @Override
  @Transactional(readOnly = true)
  public void addStore(Long ownerId, AddStoreCommand.Request req) {
    repositoryPort.findById(ownerId);
    messageSenderPort.sendAddStore(ownerId, req);
  }
}
