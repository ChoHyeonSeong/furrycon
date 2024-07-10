package com.wasabi.furrycon.convention;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ConventionRepository extends JpaRepository<ConventionEntity,Long>, JpaSpecificationExecutor<ConventionEntity> {
}
