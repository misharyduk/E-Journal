package com.ejournal.university.faculty.service;

import com.ejournal.university.common.dto.ResponseDto;
import com.ejournal.university.faculty.dto.FacultyRequestDto;
import com.ejournal.university.faculty.dto.FacultyResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface FacultyService {

    boolean createFaculty(FacultyRequestDto facultyRequestDto);

    List<FacultyResponseDto> fetchAllFaculties();

    FacultyResponseDto fetchFaculty(Integer facultyId);

    FacultyResponseDto updateFaculty( FacultyRequestDto facultyRequestDto);

    boolean deleteFaculty(Integer facultyId);
}
