package com.ejournal.university.info.controller;

import com.ejournal.university.common.dto.ResponseDto;
import com.ejournal.university.info.dto.UniversityDto;
import com.ejournal.university.info.service.UniversityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.ejournal.university.common.util.ServiceConstants.*;

@RestController
@RequestMapping("/api/v1/university")
@RequiredArgsConstructor
public class UniversityController {

    private final UniversityService universityService;

    @PostMapping
    public ResponseEntity<ResponseDto> createUniversity(@RequestBody UniversityDto universityRequestDto){

        universityService.createUniversity(universityRequestDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto(STATUS_CODE_201, "University" + STATUS_MESSAGE_201));
    }

    @GetMapping
    public ResponseEntity<UniversityDto> fetchUniversityDetails(){

        UniversityDto universityDto = universityService.fetchUniversityDetails();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(universityDto);
    }

    @PutMapping
    public ResponseEntity<UniversityDto> updateUniversityDetails(@RequestBody UniversityDto universityRequestDto){

        UniversityDto updatedUniversityDto = universityService.updateUniversityDetails(universityRequestDto);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(updatedUniversityDto);
    }

    @DeleteMapping
    public ResponseEntity<ResponseDto> deleteUniversity(){

        universityService.deleteUniversity();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ResponseDto(HttpStatus.OK.toString(), "University" + INSTANCE_DELETED));
    }

}
