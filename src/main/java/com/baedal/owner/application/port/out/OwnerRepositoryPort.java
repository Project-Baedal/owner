package com.baedal.owner.application.port.out;

import com.baedal.owner.domain.model.Owner;
import com.baedal.owner.domain.model.OwnerAuthentication;

public interface OwnerRepositoryPort {

  Owner findById(Long id);

  boolean emailAlreadyExist(String email);

  Long save(String email, String name, String password);

  OwnerAuthentication findByEmail(String email);
}
