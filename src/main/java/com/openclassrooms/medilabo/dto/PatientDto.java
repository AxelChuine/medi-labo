package com.openclassrooms.medilabo.dto;

import com.openclassrooms.medilabo.enums.GenderEnum;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientDto {
    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private GenderEnum gender;
    private String address;
    private String cellNumber;
}
