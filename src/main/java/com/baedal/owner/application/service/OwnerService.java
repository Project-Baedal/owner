package com.baedal.owner.application.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baedal.owner.application.command.AddStoreCommand;
import com.baedal.owner.application.command.LoginCommand;
import com.baedal.owner.application.mapper.OwnerApplicationMapper;
import com.baedal.owner.application.port.in.OwnerUseCase;
import com.baedal.owner.application.port.out.MessageSenderPort;
import com.baedal.owner.application.port.out.OwnerRepositoryPort;
import com.baedal.owner.domain.model.Owner;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class OwnerService implements OwnerUseCase {

	private final OwnerRepositoryPort repositoryPort;
	private final OwnerApplicationMapper mapper;
	private final MessageSenderPort messageSenderPort;

	@Override
	@Transactional(readOnly = true)
	public LoginCommand.Response login(LoginCommand.Request req) {
		Owner owner = repositoryPort.findActiveUserByAccountAndPassword(req.getAccount(), req.getPassword());
		return mapper.toLoginResponse(owner);
	}

	@Override
	public void addStore(Long ownerId, AddStoreCommand.Request req) {
		messageSenderPort.sendAddStore(ownerId, req);
	}
}
