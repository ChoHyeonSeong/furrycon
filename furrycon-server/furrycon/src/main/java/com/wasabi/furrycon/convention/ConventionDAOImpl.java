package com.wasabi.furrycon.convention;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ConventionDAOImpl implements ConventionDAO{
    private final ConventionRepository repo;

    @Override
    public Slice<ConventionEntity> readAllConvention(Pageable pageable) {
        return repo.findAll(pageable);
    }

    @Override
    public Slice<ConventionEntity> readConventions(String countryCode, LocalDate startDate, LocalDate endDate, Boolean confirmedLocation, Pageable pageable) {
        return repo.findConventions(countryCode, startDate, endDate, confirmedLocation, pageable);
    }

    @Override
    public void createConvention(ConventionEntity entity) {
        repo.save(entity);
    }
}
