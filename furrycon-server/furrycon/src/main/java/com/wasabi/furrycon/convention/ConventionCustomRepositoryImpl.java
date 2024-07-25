package com.wasabi.furrycon.convention;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.SliceImpl;
import org.springframework.util.StringUtils;

import static com.wasabi.furrycon.convention.QConventionEntity.conventionEntity;

import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
public class ConventionCustomRepositoryImpl implements ConventionCustomRepository {
    private final JPAQueryFactory factory;

    @Override
    public Slice<ConventionEntity> findConventions(String countryCode, LocalDate startDate, LocalDate endDate, Pageable pageable) {
        List<ConventionEntity> conventions = factory
                .selectFrom(conventionEntity)
                .where(eqCountryCode(countryCode),
                        betweenSchedule(startDate,endDate))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize()+1)
                .orderBy(conventionEntity.startDate.asc(),conventionEntity.endDate.asc())
                .fetch();
        boolean hasNext = false;
        if (conventions.size() > pageable.getPageSize()) {
            conventions.remove(pageable.getPageSize());
            hasNext = true;
        }
        return new SliceImpl<>(conventions, pageable, hasNext);
    }

    private BooleanExpression eqCountryCode(String countryCode) {
        if(StringUtils.hasText(countryCode))
            return conventionEntity.countryCode.eq(countryCode);
        return null;
    }

    private BooleanExpression betweenSchedule(LocalDate startDate, LocalDate endDate) {
        if(startDate != null && endDate != null)
            return conventionEntity.startDate.between(startDate, endDate)
                    .and(conventionEntity.endDate.between(startDate, endDate));
        return null;
    }

}
