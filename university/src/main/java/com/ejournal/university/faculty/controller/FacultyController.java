package com.ejournal.university.faculty.controller;

import com.ejournal.university.faculty.dto.FacultyRequestDto;
import com.ejournal.university.faculty.dto.FacultyResponseDto;
import com.ejournal.university.common.dto.ResponseDto;
import com.ejournal.university.faculty.service.FacultyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.ejournal.university.common.util.ServiceConstants.INSTANCE_DELETED;

@RestController
@RequestMapping("/api/v1/faculties")
@RequiredArgsConstructor
public class FacultyController {

    private final FacultyService facultyService;

    @PostMapping
    public ResponseEntity<FacultyResponseDto> createFaculty(@RequestBody FacultyRequestDto facultyRequestDto){

        FacultyResponseDto responseDto = facultyService.create(facultyRequestDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(responseDto);
    }

    @GetMapping
    public ResponseEntity<List<FacultyResponseDto>> fetchAllFaculties(){

        List<FacultyResponseDto> responseDTOs = facultyService.fetchAll();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(responseDTOs);
    }

    @GetMapping("/{facultyId}")
    public ResponseEntity<FacultyResponseDto> fetchFaculty(@PathVariable("facultyId") Long facultyId){

        FacultyResponseDto responseDto = facultyService.fetchById(facultyId);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(responseDto);
    }

    @PutMapping("/{facultyId}")
    public ResponseEntity<FacultyResponseDto> updateFaculty(@PathVariable("facultyId") Long facultyId,
                                                            @RequestBody FacultyRequestDto facultyRequestDto){
        FacultyResponseDto updatedResponseDto = facultyService.update(facultyId, facultyRequestDto);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(updatedResponseDto);
    }

    @DeleteMapping("/{facultyId}")
    public ResponseEntity<ResponseDto> deleteFaculty(@PathVariable("facultyId") Long facultyId){

        facultyService.deleteById(facultyId);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ResponseDto(HttpStatus.OK.toString(), "Faculty" + INSTANCE_DELETED));
    }

}
