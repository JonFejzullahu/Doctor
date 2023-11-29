package com.example.projekti_mjeket.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorChangeStatusDto {
    private long id;
    private boolean active;
}
