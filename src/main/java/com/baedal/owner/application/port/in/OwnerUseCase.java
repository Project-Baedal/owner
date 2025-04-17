package com.baedal.owner.application.port.in;

import com.baedal.owner.application.command.AddStoreCommand;
import com.baedal.owner.application.command.LoginCommand;

public interface OwnerUseCase {

  LoginCommand.Response login(LoginCommand.Request req);

  void addStore(Long ownerId, AddStoreCommand.Request req);
}
