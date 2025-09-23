package com.openclassrooms.medilabo.service;

import com.openclassrooms.medilabo.domain.Patient;
import com.openclassrooms.medilabo.dto.PatientDto;
import com.openclassrooms.medilabo.repository.IPatientRepository;
import com.openclassrooms.medilabo.service.mapper.PatientMapper;
import org.apache.catalina.mapper.Mapper;
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
        return this.mapper.toDtoSet(new HashSet<>(repository.findAll()));
    }
}
