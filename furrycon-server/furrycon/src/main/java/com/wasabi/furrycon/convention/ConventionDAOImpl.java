package com.wasabi.furrycon.convention;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;

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
    public Slice<ConventionEntity> readConventions(String countryCode, Date startDate, Date endDate, boolean confirmedLocation, Pageable pageable) {
        Specification<ConventionEntity> spec = Specification
                .where(ConventionSpecification.withCountryCodeEqual(countryCode))
                .and(ConventionSpecification.withScheduleBetween(startDate, endDate));
        if(confirmedLocation)
            spec = spec.and(ConventionSpecification.withLocationIsNotNull());
        return repo.findAll(spec,pageable);
    }

    @Override
    public void createConvention(ConventionEntity entity) {
        repo.save(entity);
    }
}
