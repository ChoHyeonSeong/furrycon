package com.wasabi.furrycon.convention;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ConventionController {
    private final ConventionService conventionService;

    @GetMapping("/conventions")
    public Slice<ConventionDTO> readAllConvention(@PageableDefault(page = 0, size = 10, sort = "startDate", direction = Sort.Direction.ASC) Pageable pageable) {
        return conventionService.readAllConvention(pageable);
    }

    @GetMapping("/convention")
    public Slice<ConventionDTO> readConventions(
            @RequestParam String countryCode,
            @RequestParam Date startDate,
            @RequestParam Date endDate,
            @RequestParam(defaultValue = "false") boolean confirmedLocation,
            @PageableDefault(page = 0, size = 10, sort = "startDate", direction = Sort.Direction.ASC) Pageable pageable) {
        return conventionService.readConventions(countryCode,startDate,endDate,confirmedLocation,pageable);
    }

    public String createConvention(ConventionDTO conventionDTO) {

    }
}
