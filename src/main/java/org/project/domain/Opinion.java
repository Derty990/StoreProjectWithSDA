package org.project.domain;

import lombok.*;

import java.time.OffsetDateTime;

@With
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Opinion {

    private Long id;
    private Customer customer;
    private Product product;
    private Byte stars;
    private String comment;
    private OffsetDateTime dateTime;

}
