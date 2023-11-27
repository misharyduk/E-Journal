package com.ejournal.university.faculty.service.impl;

import com.ejournal.university.common.dto.AddressDto;
import com.ejournal.university.common.exception.ResourceNotFoundException;
import com.ejournal.university.faculty.dto.FacultyRequestDto;
import com.ejournal.university.faculty.dto.FacultyResponseDto;
import com.ejournal.university.faculty.entity.Faculty;
import com.ejournal.university.faculty.mapper.FacultyMapper;
import com.ejournal.university.faculty.repository.FacultyRepository;
import com.ejournal.university.faculty.service.FacultyService;
import com.ejournal.university.teacher.dto.TeacherResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FacultyServiceImpl implements FacultyService {

    private final FacultyRepository facultyRepository;

//    private static final List<FacultyResponseDto> FACULTIES = new ArrayList<>(){
//        {
//            FacultyResponseDto.builder()
//                    .setFacultyName("Факультет кібербезпеки та програмної інженерії")
//                    .setFacultyDescription("2100 - здобувачів на факультеті, 137 - професорсько-викдадацький склад, 40- допоміжний склад")
//                    .setAddress(new AddressDto("Україна", "Київ", "пр. Гузара Любомира", "1", "03058"))
//                    .setOfficeNumber("корп. 11, каб.205")
//                    .setEmail("fkpi@npp.nau.edu.ua")
//                    .setMobilePhone("+38(044) 406-70-08")
//                    .setDean(new TeacherResponseDto())
//                    .build();
//        }
//    };

    @Override
    public FacultyResponseDto create(FacultyRequestDto requestDto) {
        Faculty faculty = FacultyMapper.mapToEntity(requestDto, new Faculty());
        return FacultyMapper.mapToDto(facultyRepository.createInstance(faculty));
    }

    @Override
    public FacultyResponseDto fetchById(Long id) {
        Faculty faculty = facultyRepository.fetchInstanceById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Faculty", "id", String.valueOf(id)));
        return FacultyMapper.mapToDto(faculty);
    }

    @Override
    public List<FacultyResponseDto> fetchAll() {
        List<Faculty> allFaculties = facultyRepository.fetchAllInstances();
        return allFaculties.stream()
                .map(FacultyMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public FacultyResponseDto update(Long id, FacultyRequestDto requestDto) {
        Faculty faculty = facultyRepository.fetchInstanceById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Faculty", "id", String.valueOf(id)));
        Faculty updatedFaculty = FacultyMapper.mapToEntity(requestDto, faculty);
        updatedFaculty = facultyRepository.updateInstance(updatedFaculty);
        return FacultyMapper.mapToDto(updatedFaculty);
    }

    @Override
    public boolean deleteById(Long id) {
        Faculty faculty = facultyRepository.fetchInstanceById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Faculty", "id", String.valueOf(id)));
        facultyRepository.deleteInstance(faculty);
        return true;
    }
}
