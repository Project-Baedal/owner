package com.baedal.owner.application.port.in;

import com.baedal.owner.application.command.SignupCommand;

public interface OwnerSignupUsecase {

  SignupCommand.Response signup(SignupCommand.Request req);
}
