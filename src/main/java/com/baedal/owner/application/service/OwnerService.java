package com.baedal.owner.application.service;

import org.springframework.stereotype.Service;

import com.baedal.owner.application.command.LoginCommand;
import com.baedal.owner.application.mapper.OwnerApplicationMapper;
import com.baedal.owner.application.port.in.OwnerUseCase;
import com.baedal.owner.application.port.out.OwnerRepositoryPort;
import com.baedal.owner.domain.model.Owner;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class OwnerService implements OwnerUseCase {

	private final OwnerRepositoryPort repositoryPort;
	private final OwnerApplicationMapper mapper;

	@Override
	public LoginCommand.Response login(LoginCommand.Request req) {
		Owner owner = repositoryPort.findActiveUserByAccountAndPassword(req.getAccount(), req.getPassword());
		return mapper.toLoginResponse(owner);
	}
}
