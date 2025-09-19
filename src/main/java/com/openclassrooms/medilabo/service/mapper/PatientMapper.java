package com.openclassrooms.medilabo.service.mapper;

import com.openclassrooms.medilabo.domain.Patient;
import com.openclassrooms.medilabo.dto.PatientDto;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Service
public class PatientMapper {
    public Patient toModel(PatientDto dto) {
        Patient model = new Patient();
        model.setId(dto.getId());
        model.setFirstName(dto.getFirstName());
        model.setLastName(dto.getLastName());
        model.setBirthDate(dto.getBirthDate());
        model.setGender(dto.getGender());
        model.setAddress(dto.getAddress());
        model.setCellNumber(dto.getCellNumber());
        return model;
    }

    public PatientDto toDto(Patient model) {
        PatientDto dto = new PatientDto();
        dto.setId(model.getId());
        dto.setFirstName(model.getFirstName());
        dto.setLastName(model.getLastName());
        dto.setBirthDate(model.getBirthDate());
        dto.setGender(model.getGender());
        dto.setAddress(model.getAddress());
        dto.setCellNumber(model.getCellNumber());
        return dto;
    }

    public Set<PatientDto> toDtoSet(Set<Patient> model) {
        Set<PatientDto> set = new HashSet<>();
        for (Patient patient : model) {
            set.add(toDto(patient));
        }
        return set;
    }

    public Set<Patient> toModelSet(Set<PatientDto> dto) {
        Set<Patient> set = new HashSet<>();
        for (PatientDto patient : dto) {
            set.add(toModel(patient));
        }
        return set;
    }

    public Patient save(PatientDto dto) {
        Patient model = new Patient();
        model.setId(Objects.isNull(dto.getId()) ? null : dto.getId());
        return model;
    }
}
