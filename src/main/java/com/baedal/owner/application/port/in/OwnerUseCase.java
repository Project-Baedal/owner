package com.baedal.owner.application.port.in;

import com.baedal.owner.application.command.AddStoreCommand;

public interface OwnerUseCase {

  void addStore(Long ownerId, AddStoreCommand.Request req);
}
