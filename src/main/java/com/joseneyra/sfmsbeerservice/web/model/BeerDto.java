package com.joseneyra.sfmsbeerservice.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

@Data       // Lombok Data gives us Getters, Setters, Equals, HashCodes
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BeerDto {

    private UUID id;
    private Integer version;

    private OffsetDateTime createdDate;             // UTC Date (best practice for WebApps is to use UTC Dates)
    private OffsetDateTime lastModifiedDate;

    private String beerName;

    private BeerStyleEnum beerStyle;

    private Long upc;

    private BigDecimal price;

    private Integer quantityOnHand;
}
