package com.baedal.owner.application.port.in;

import com.baedal.owner.application.command.LoginCommand;
import com.baedal.owner.application.command.SignupCommand;

public interface OwnerAuthenticateUsecase {

  LoginCommand.Response login(LoginCommand.Request req);

  SignupCommand.Response signUp(SignupCommand.Request req);
}
