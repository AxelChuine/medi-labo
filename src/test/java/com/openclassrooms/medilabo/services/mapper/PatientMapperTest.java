package com.openclassrooms.medilabo.services.mapper;

import com.openclassrooms.medilabo.domain.Patient;
import com.openclassrooms.medilabo.dto.PatientDto;
import com.openclassrooms.medilabo.enums.GenderEnum;
import com.openclassrooms.medilabo.service.mapper.PatientMapper;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.*;

@ExtendWith(MockitoExtension.class)
public class PatientMapperTest {

    @InjectMocks
    private PatientMapper mapper;

    private final Long id = 1L;
    private final String firstName =  "FirstName";
    private final String lastName = "LastName";
    private final LocalDate birthDate = LocalDate.now();
    private final GenderEnum  gender = GenderEnum.M;
    private final String address = "Address";

    private Patient patient;
    private PatientDto patientDto;
    private Set<PatientDto> setDto;
    private Set<Patient> set;
    private List<PatientDto> dtoList;
    private List<Patient> list;

    @BeforeEach
    public void setUp() {
        patient = new Patient();
        patientDto = new PatientDto();

        patientDto.setId(id);
        patientDto.setFirstName(firstName);
        patientDto.setLastName(lastName);
        patientDto.setBirthDate(birthDate);
        patientDto.setGender(gender);
        patientDto.setAddress(address);

        patient.setId(id);
        patient.setFirstName(firstName);
        patient.setLastName(lastName);
        patient.setBirthDate(birthDate);
        patient.setGender(gender);
        patient.setAddress(address);

        this.list = new ArrayList<>();
        this.list.add(patient);
        this.dtoList = new ArrayList<>();
        this.dtoList.add(patientDto);
        this.setDto = new HashSet<>();
        this.setDto.add(patientDto);
        this.set = new HashSet<>();
        this.set.add(this.patient);
    }

    @Test
    public void toDtoTest() {
        PatientDto toReturn = this.mapper.toDto(patient);

        Assertions.assertThat(toReturn).isNotNull();
        Assertions.assertThat(toReturn).isEqualTo(patientDto);
    }

    @Test
    public void toModelTest() {
        Patient toReturn = this.mapper.toModel(patientDto);

        Assertions.assertThat(toReturn).isNotNull();
        Assertions.assertThat(toReturn).isEqualTo(patient);
    }

    @Test
    public void saveTest() {
        Patient toReturn = this.mapper.save(Optional.of(this.patient), patientDto);

        Assertions.assertThat(toReturn).isNotNull();
        Assertions.assertThat(toReturn).isEqualTo(this.patient);
    }

    @Test
    public void toDtoList() {
        List<PatientDto> toReturn = this.mapper.toDtoList(list);

        Assertions.assertThat(toReturn).isNotNull();
        Assertions.assertThat(toReturn).isNotEmpty();
        Assertions.assertThat(toReturn).isEqualTo(dtoList);
    }

    @Test
    public void toDtoSetTest() {
        Set<PatientDto> toReturn = this.mapper.toDtoSet(this.list);

        Assertions.assertThat(toReturn).isNotNull();
        Assertions.assertThat(toReturn).isNotEmpty();
        Assertions.assertThat(toReturn).isEqualTo(this.setDto);
    }

    @Test
    public void toModelSetTest() {
        Set<Patient> toReturn = this.mapper.toModelSet(this.setDto);

        Assertions.assertThat(toReturn).isNotNull();
        Assertions.assertThat(toReturn).isNotEmpty();
        Assertions.assertThat(toReturn).isEqualTo(this.set);
    }

    @Test
    public void toModelListTest() {
        List<Patient> toReturn = this.mapper.toModelList(this.dtoList);

        Assertions.assertThat(toReturn).isNotNull();
        Assertions.assertThat(toReturn).isNotEmpty();
        Assertions.assertThat(toReturn).isEqualTo(this.list);
    }
}
