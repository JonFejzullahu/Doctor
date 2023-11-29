package com.example.projekti_mjeket.controllers;

import com.example.projekti_mjeket.models.DoctorChangeStatusDto;
import com.example.projekti_mjeket.models.DoctorDto;
import com.example.projekti_mjeket.services.DoctorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/doctors")
@CrossOrigin(origins = "*")
public class DoctorController {
    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping
    public List<DoctorDto> getAllDoctors() {
        return doctorService.getAll();
    }

    @GetMapping("/{id}")
    public DoctorDto getDoctorById(@PathVariable long id) {
        return doctorService.getById(id);
    }

    @PostMapping
    public void addDoctor(@RequestBody DoctorDto doctorDto) {
        doctorService.add(doctorDto);
    }

    @PutMapping("/{id}")
    public void updateDoctor(@PathVariable long id, @RequestBody DoctorDto doctorDto) {
        doctorService.update(id, doctorDto);

    }

    @PatchMapping("/{id}")
    public void updateDoctorStatus(@PathVariable long id, @RequestBody DoctorChangeStatusDto doctorDto) {
        doctorService.changeStatus(id, doctorDto);

    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable long id) {
        doctorService.deleteById(id);
    }


}
