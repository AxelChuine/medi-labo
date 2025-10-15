package com.openclassrooms.medilabo.service.mapper;

import com.openclassrooms.medilabo.domain.Patient;
import com.openclassrooms.medilabo.dto.PatientDto;
import com.openclassrooms.medilabo.exceptions.NoPatientFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

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

    public Set<PatientDto> toDtoSet(List<Patient> model) {
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

    public Patient save(Optional<Patient> optional, PatientDto dto) {
        Patient model;
        if (optional.isPresent()) {
            model = optional.get();
        } else {
            throw new NoPatientFoundException("Aucun patient avec cet id n'existe.");
        }
        model.setId(Objects.isNull(dto.getId()) ? model.getId() : dto.getId());
        model.setFirstName(Objects.isNull(dto.getFirstName()) ? model.getFirstName() : dto.getFirstName());
        model.setLastName(Objects.isNull(dto.getLastName()) ? model.getLastName() : dto.getLastName());
        model.setBirthDate(Objects.isNull(dto.getBirthDate()) ? model.getBirthDate() : dto.getBirthDate());
        model.setGender(Objects.isNull(dto.getGender()) ? model.getGender() : dto.getGender());
        model.setAddress(Objects.isNull(dto.getAddress()) ? model.getAddress() : dto.getAddress());
        model.setCellNumber(Objects.isNull(dto.getCellNumber()) ? model.getCellNumber() : dto.getCellNumber());
        return model;
    }

    public List<PatientDto> toDtoList(List<Patient> models) {
        List<PatientDto> list = new ArrayList<>();
        for (Patient m : models) {
            list.add(toDto(m));
        }
        return list;
    }

    public List<Patient> toModelList(List<PatientDto> dtoList) {
        List<Patient> list = new ArrayList<>();
        for (PatientDto dto : dtoList) {
            list.add(toModel(dto));
        }
        return list;
    }
}
