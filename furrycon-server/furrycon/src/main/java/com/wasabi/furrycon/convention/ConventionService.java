package com.wasabi.furrycon.convention;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

public interface ConventionService {
    Slice<ConventionDTO> readAllConvention(Pageable pageable);
    Slice<ConventionDTO> readConventions(String countryCode, Date startDate, Date endDate, boolean confirmedLocation, Pageable pageable);
    void createConvention(ConventionDTO dto);
}
