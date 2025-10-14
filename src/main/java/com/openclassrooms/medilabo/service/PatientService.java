package com.openclassrooms.medilabo.service;

import com.openclassrooms.medilabo.dto.PatientDto;
import com.openclassrooms.medilabo.exceptions.AlreadyExistsException;
import com.openclassrooms.medilabo.repository.IPatientRepository;
import com.openclassrooms.medilabo.service.mapper.PatientMapper;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class PatientService {
    private final IPatientRepository repository;

    private final PatientMapper mapper;

    public PatientService(IPatientRepository repository, PatientMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public Set<PatientDto> findAll() {
        return this.mapper.toDtoSet(repository.findAll());
    }

    public PatientDto create(PatientDto dto) {
        List<PatientDto> all = this.mapper.toDtoList(this.repository.findAll());
        if (all.contains(dto)) {
            throw new AlreadyExistsException("Le patient existe déjà.");
        }
        return this.mapper.toDto(this.repository.save(this.mapper.toModel(dto)));
    }
}
