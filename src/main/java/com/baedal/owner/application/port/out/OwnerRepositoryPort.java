package com.baedal.owner.application.port.out;

import com.baedal.owner.domain.model.Owner;

public interface OwnerRepositoryPort {

  Owner findById(Long id);

  boolean emailAlreadyExist(String email);
}
