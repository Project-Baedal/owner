package com.baedal.owner.application.port.in;

import com.baedal.owner.adapter.in.web.dto.command.LoginCommand;

public interface OwnerUseCase {
	LoginCommand.Response login(LoginCommand.Request req);
}
