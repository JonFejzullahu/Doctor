package com.example.projekti_mjeket.mappers;

import com.example.projekti_mjeket.entities.DoctorEntity;
import com.example.projekti_mjeket.models.DoctorChangeStatusDto;
import com.example.projekti_mjeket.models.DoctorDto;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class DoctorMapper {

    public DoctorEntity toEntity(DoctorDto from) {
        var to = new DoctorEntity();
        to.setId(from.getId());
        to.setName(from.getName());
        to.setBirthdate(from.getBirthdate());
        to.setActive(from.isActive());
        to.setSurname(from.getSurname());
        to.setProfileDoctor(from.getProfileDoctor());
        to.setRegisterDate(from.getRegisterDate());
        to.setCreatedAt(LocalDateTime.now());
        to.setCreatedBy("Admin");
        return to;
    }

    public DoctorDto toDto(DoctorEntity from) {
        var to = new DoctorDto();
        to.setId(from.getId());
        to.setName(from.getName());
        to.setBirthdate(from.getBirthdate());
        to.setActive(from.isActive());
        to.setSurname(from.getSurname());
        to.setProfileDoctor(from.getProfileDoctor());
        to.setRegisterDate(from.getRegisterDate());
        return to;
    }

    public DoctorChangeStatusDto toChangeStatusDto(DoctorEntity from) {
        var to = new DoctorChangeStatusDto();
        to.setId(from.getId());
        to.setActive(from.isActive());
        return to;
    }
}
