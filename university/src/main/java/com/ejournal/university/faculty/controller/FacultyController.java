package com.ejournal.university.faculty.controller;

import com.ejournal.university.faculty.dto.FacultyRequestDto;
import com.ejournal.university.faculty.dto.FacultyResponseDto;
import com.ejournal.university.common.dto.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/faculties")
public class FacultyController {

    @PostMapping
    public ResponseEntity<ResponseDto> createFaculty(@RequestBody FacultyRequestDto facultyRequestDto){

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto(HttpStatus.CREATED.toString(), "Faculty has been successfully created"));
    }

    @GetMapping
    public ResponseEntity<List<FacultyResponseDto>> fetchAllFaculties(){

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(List.of());
    }

    @GetMapping("/{facultyId}")
    public ResponseEntity<FacultyResponseDto> fetchFaculty(@PathVariable("facultyId") Integer facultyId){

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new FacultyResponseDto());
    }

    @PutMapping
    public ResponseEntity<FacultyResponseDto> updateFaculty(@RequestBody FacultyRequestDto facultyRequestDto){

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new FacultyResponseDto());
    }

    @DeleteMapping("/{facultyId}")
    public ResponseEntity<ResponseDto> deleteFaculty(@PathVariable("facultyId") Integer facultyId){

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ResponseDto(HttpStatus.OK.toString(), "Faculty has been successfully created"));
    }

}
