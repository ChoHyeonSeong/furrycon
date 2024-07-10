package com.wasabi.furrycon.convention;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

import java.util.Date;
import java.util.List;

public interface ConventionDAO {
    Slice<ConventionEntity> readAllConvention(Pageable pageable);
    Slice<ConventionEntity> readConventions(String countryCode, Date startDate, Date endDate, boolean confirmedLocation, Pageable pageable);
    void createConvention(ConventionEntity entity);
}
