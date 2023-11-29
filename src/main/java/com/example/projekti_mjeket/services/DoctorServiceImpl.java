package com.example.projekti_mjeket.services;

import com.example.projekti_mjeket.entities.DoctorEntity;
import com.example.projekti_mjeket.mappers.DoctorMapper;
import com.example.projekti_mjeket.models.DoctorChangeStatusDto;
import com.example.projekti_mjeket.models.DoctorDto;
import com.example.projekti_mjeket.repositories.DoctorRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class DoctorServiceImpl implements DoctorService {
    private final DoctorRepository repository;
    private final DoctorMapper mapper;

    public DoctorServiceImpl(DoctorRepository repository, DoctorMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }


    @Override
    public boolean add(DoctorDto doctorDto) {
        var entity = mapper.toEntity(doctorDto);
        repository.save(entity);
        return true;
    }

    @Override
    public List<DoctorDto> getAll() {
        return repository.findAll().stream().map(mapper::toDto).toList();
    }

    @Override
    public DoctorDto getById(long id) {
        var optionalEntity = repository.findById(id);
        if (optionalEntity.isEmpty())
            throw new EntityNotFoundException("Doctor not found with id " + id);
        var entity = optionalEntity.get();
        var dto = mapper.toDto(entity);
        return dto;
    }

    @Override
    public boolean update(long id, DoctorDto dto) {
        var optionalDoctor = repository.findById(id);
        if (optionalDoctor.isEmpty())
            throw new EntityNotFoundException("Doctor not found with id " + id);

        var entity = optionalDoctor.get();
        entity.setName(dto.getName());
        entity.setSurname(dto.getSurname());
        entity.setBirthdate(dto.getBirthdate());
        entity.setProfileDoctor(dto.getProfileDoctor());
        entity.setActive(dto.isActive());
        entity.setRegisterDate(dto.getRegisterDate());

        repository.save(entity);
        return true;
    }

    @Override
    public boolean deleteById(long id) {
        repository.deleteById(id);
        return true;
    }

    @Override
    public boolean changeStatus(long id, DoctorChangeStatusDto dto) {
        var optionalDoctor = repository.findById(id);
        if (optionalDoctor.isEmpty())
            throw new EntityNotFoundException("Doctor not found with id " + id);
        var entity = optionalDoctor.get();
        entity.setActive(dto.isActive());
        repository.save(entity);
        return true;
    }
}
