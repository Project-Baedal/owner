package com.baedal.owner.application.port.out;

import com.baedal.owner.application.command.AddStoreCommand;

public interface MessageSenderPort {
	void sendAddStore(Long ownerId, AddStoreCommand.Request req);
}
