package com.baedal.owner.adapter.out.persistence.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.baedal.owner.adapter.out.persistence.entity.OwnerEntity;

public interface OwnerJpaRepository extends JpaRepository<OwnerEntity, Long> {

  Optional<OwnerEntity> findByEmail(String email);
}
