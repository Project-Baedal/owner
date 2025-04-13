package com.baedal.owner.application.port.out;

import com.baedal.owner.domain.model.Owner;

public interface OwnerRepositoryPort {

	Owner findActiveUserByAccountAndPassword(String account, String password);
}
