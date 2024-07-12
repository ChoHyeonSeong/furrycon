package com.wasabi.furrycon.convention;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ConventionController {
    private final ConventionService conventionService;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @GetMapping("/conventions")
    public Slice<ConventionDTO> readAllConvention(@PageableDefault(page = 0, size = 10, sort = "startDate", direction = Sort.Direction.ASC) Pageable pageable) {
        return conventionService.readAllConvention(pageable);
    }

    @GetMapping("/convention")
    public Slice<ConventionDTO> readConventions(
            @PageableDefault(page = 0, size = 10, sort = "startDate", direction = Sort.Direction.ASC) Pageable pageable,
            @RequestParam(required = false) String countryCode,
            @RequestParam(required = false)  String startDate,
            @RequestParam(required = false)  String endDate,
            @RequestParam(defaultValue = "false") boolean confirmedLocation) {
        System.out.println(startDate);
        System.out.println(endDate);
        return conventionService.readConventions(countryCode,LocalDate.parse(startDate),LocalDate.parse(endDate),confirmedLocation,pageable);
    }

    @PostMapping("/convention")
    public String createConvention(@RequestBody ConventionDTO convention) {
        conventionService.createConvention(convention);
        return "OK";
    }
}
