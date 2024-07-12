package com.wasabi.furrycon.convention;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ConventionRepository extends JpaRepository<ConventionEntity,Long>, ConventionCustomRepository {
}
