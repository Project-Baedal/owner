package com.baedal.owner.application.port.in;

import com.baedal.owner.application.command.SignupCommand;

public interface OwnerSignUpUsecase {

  SignupCommand.Response signUp(SignupCommand.Request req);
}
