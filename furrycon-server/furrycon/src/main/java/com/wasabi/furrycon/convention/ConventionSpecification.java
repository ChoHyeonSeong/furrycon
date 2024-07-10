package com.wasabi.furrycon.convention;

import org.springframework.data.jpa.domain.Specification;

import java.util.Date;

public class ConventionSpecification {
    public static Specification<ConventionEntity> withCountryCodeEqual(String countryCode) {
        return ((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("countryCode"),countryCode));
    }
    public static Specification<ConventionEntity> withScheduleBetween(Date startDate, Date endDate) {
        return ((root, query, criteriaBuilder) -> criteriaBuilder.and(
                criteriaBuilder.between(root.get("startDate"),startDate,endDate),
                criteriaBuilder.between(root.get("endDate"),startDate,endDate)
        ));
    }
    public static Specification<ConventionEntity> withLocationIsNotNull() {
        return ((root, query, criteriaBuilder) -> criteriaBuilder.isNotNull(root.get("location")));
    }
}
