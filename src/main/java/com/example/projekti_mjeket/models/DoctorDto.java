package com.example.projekti_mjeket.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorDto {
    private long id;
    private String name;
    private String surname;
    private LocalDate birthdate;
    private String profileDoctor;
    private LocalDate registerDate;
    private boolean active = true;
}
