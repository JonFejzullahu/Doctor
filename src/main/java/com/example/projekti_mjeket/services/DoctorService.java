package com.example.projekti_mjeket.services;

import com.example.projekti_mjeket.models.DoctorChangeStatusDto;
import com.example.projekti_mjeket.models.DoctorDto;

import java.util.List;

public interface DoctorService {

    boolean add(DoctorDto doctorDto);

    List<DoctorDto> getAll();

    DoctorDto getById(long id);

    boolean update(long id, DoctorDto updatedDoctorDto);

    boolean deleteById(long id);

    boolean changeStatus(long id, DoctorChangeStatusDto dto);
}
