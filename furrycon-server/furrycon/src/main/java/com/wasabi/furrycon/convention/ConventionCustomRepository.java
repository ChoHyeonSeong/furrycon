package com.wasabi.furrycon.convention;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

import java.time.LocalDate;
import java.util.Date;

public interface ConventionCustomRepository {
    Slice<ConventionEntity> findConventions(String countryCode, LocalDate startDate, LocalDate endDate, Pageable pageable);
}
