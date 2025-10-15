package com.openclassrooms.medilabo.services;

import com.openclassrooms.medilabo.domain.Patient;
import com.openclassrooms.medilabo.dto.PatientDto;
import com.openclassrooms.medilabo.enums.GenderEnum;
import com.openclassrooms.medilabo.repository.IPatientRepository;
import com.openclassrooms.medilabo.service.PatientService;
import com.openclassrooms.medilabo.service.mapper.PatientMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class PatientServiceTest {
    @InjectMocks
    private PatientService service;

    @Mock
    private IPatientRepository repository;

    @Mock
    private PatientMapper mapper;

    private final Long id = 1L;
    private final String firstName = "John";
    private final String lastName = "Doe";
    private final LocalDate birthDate = LocalDate.now();
    private final GenderEnum gender = GenderEnum.M;
    private final String address = "12 rue de LaBenne";
    private final String cellPhone = "01";
    private Patient patient;
    private PatientDto patientDto;
    private Set<PatientDto> setDto;
    private List<Patient> list;
    private List<PatientDto> dtoList;

    @BeforeEach
    public void setUp() {
        patient = new Patient();
        patient.setId(id);
        patient.setFirstName(firstName);
        patient.setLastName(lastName);
        patient.setBirthDate(birthDate);
        patient.setAddress(address);
        patient.setGender(gender);
        patient.setCellNumber(cellPhone);

        patientDto = new PatientDto();
        patientDto.setId(id);
        patientDto.setFirstName(firstName);
        patientDto.setLastName(lastName);
        patientDto.setBirthDate(birthDate);
        patientDto.setAddress(address);
        patientDto.setGender(gender);
        patientDto.setCellNumber(cellPhone);
        setDto = new HashSet<PatientDto>();
        list = new ArrayList<>();
        this.setDto.add(patientDto);
        this.list.add(patient);
        this.dtoList = new ArrayList<>();
        this.dtoList.add(patientDto);
    }

    @Test
    public void findAllShouldReturnAllPatients() {
        Mockito.when(repository.findAll()).thenReturn(list);
        Mockito.when(this.mapper.toDtoSet(list)).thenReturn(setDto);
        Set<PatientDto> result = service.findAll();

        Assertions.assertNotNull(result);
        Assertions.assertEquals(setDto, result);
    }

    @Test
    public void createShouldReturnPatientDto() {
        PatientDto dto = new PatientDto();
        Patient model = new  Patient();

        Mockito.when(this.repository.findAll()).thenReturn(this.list);
        Mockito.when(this.mapper.toDtoList(this.list)).thenReturn(this.dtoList);
        Mockito.when(this.mapper.toModel(dto)).thenReturn(model);
        Mockito.when(this.repository.save(model)).thenReturn(model);
        Mockito.when(this.mapper.toDto(model)).thenReturn(dto);
        PatientDto p = this.service.create(dto);

        Assertions.assertNotNull(p);
        assertThat(p).isEqualTo(dto);
    }

    @Test
    public void updateShouldReturnAPatientDto() {
        PatientDto pDto = new PatientDto();
        pDto.setId(2L);
        Patient p = new Patient();
        p.setId(2L);

        Mockito.when(this.repository.findById(p.getId())).thenReturn(Optional.of(p));
        Mockito.when(this.mapper.save(Optional.of(p), pDto)).thenReturn(p);
        Mockito.when(this.mapper.toDto(p)).thenReturn(pDto);
        PatientDto toReturn = this.service.update(2L, pDto);

        Assertions.assertNotNull(toReturn);
        assertThat(toReturn).isEqualTo(pDto);
    }

}
