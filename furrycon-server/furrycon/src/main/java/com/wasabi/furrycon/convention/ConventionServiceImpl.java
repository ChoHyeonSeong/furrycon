package com.wasabi.furrycon.convention;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.SliceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ConventionServiceImpl implements ConventionService {
    private final ModelMapper mapper;
    private final ConventionDAO conventionDAO;

    @Override
    public Slice<ConventionDTO> readAllConvention(Pageable pageable) {
        return conventionDAO.readAllConvention(pageable).map(e->mapper.map(e, ConventionDTO.class));
    }

    @Override
    public Slice<ConventionDTO> readConventions(String countryCode, LocalDate startDate, LocalDate endDate, boolean confirmedLocation, Pageable pageable) {
        return conventionDAO.readConventions(countryCode,startDate,endDate,confirmedLocation,pageable).map(e->mapper.map(e, ConventionDTO.class));
    }

    @Override
    public void createConvention(ConventionDTO dto) {
        conventionDAO.createConvention(mapper.map(dto,ConventionEntity.class));
    }
}
