package com.wasabi.furrycon.convention;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@ToString
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "convention")
public class ConventionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Date startDate;
    private Date endDate;
    private String countryCode;
    private String location;
    private String homepageUrl;
}
