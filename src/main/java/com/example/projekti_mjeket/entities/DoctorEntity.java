package com.example.projekti_mjeket.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "doctors")
public class DoctorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String surname;
    private LocalDate birthdate;
    private String profileDoctor;
    private LocalDate registerDate;
    private boolean active = true;
    private LocalDateTime createdAt;
    private String createdBy;
}
