package org.project.domain;

import lombok.*;

import java.time.LocalDate;

@With
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    private Long id;
    private String userName;
    private String email;
    private String name;
    private String surname;
    private LocalDate dateOfBirth;
    private String telephoneNumber;


}








