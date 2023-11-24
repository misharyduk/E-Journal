package com.ejournal.university.faculty.service.impl;

import com.ejournal.university.common.dto.AddressDto;
import com.ejournal.university.faculty.dto.FacultyRequestDto;
import com.ejournal.university.faculty.dto.FacultyResponseDto;
import com.ejournal.university.faculty.service.FacultyService;
import com.ejournal.university.teacher.dto.TeacherResponseDto;

import java.util.ArrayList;
import java.util.List;

public class FacultyServiceImpl implements FacultyService {

    private static final List<FacultyResponseDto> FACULTIES = new ArrayList<>(){
        {
            FacultyResponseDto.builder()
                    .setFacultyName("Факультет кібербезпеки та програмної інженерії")
                    .setFacultyDescription("2100 - здобувачів на факультеті, 137 - професорсько-викдадацький склад, 40- допоміжний склад")
                    .setAddress(new AddressDto("Україна", "Київ", "пр. Гузара Любомира", "1", "03058"))
                    .setOfficeNumber("корп. 11, каб.205")
                    .setEmail("fkpi@npp.nau.edu.ua")
                    .setMobilePhone("+38(044) 406-70-08")
                    .setDean(new TeacherResponseDto())
                    .build();
        }
    };

    @Override
    public boolean createFaculty(FacultyRequestDto facultyRequestDto) {
        return true;
    }

    @Override
    public List<FacultyResponseDto> fetchAllFaculties() {
        return null;
    }

    @Override
    public FacultyResponseDto fetchFaculty(Integer facultyId) {
        return null;
    }

    @Override
    public FacultyResponseDto updateFaculty(FacultyRequestDto facultyRequestDto) {
        return null;
    }

    @Override
    public boolean deleteFaculty(Integer facultyId) {
        return false;
    }
}
