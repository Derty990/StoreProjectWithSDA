package org.project.domain;

import lombok.*;

import java.math.BigDecimal;

@With
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    private Long id;
    private String productCode;
    private String productName;
    private BigDecimal productPrice;
    private Boolean adultsOnly;
    private String description;
    private Producer producer;
}
