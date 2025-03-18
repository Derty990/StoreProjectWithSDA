package org.project.domain;

import lombok.*;

@With
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Producer {

    private Long id;
    private String producerName;
    private String address;

}