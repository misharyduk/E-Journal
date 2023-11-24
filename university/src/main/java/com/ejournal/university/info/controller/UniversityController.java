package com.ejournal.university.info.controller;

import com.ejournal.university.common.dto.ResponseDto;
import com.ejournal.university.info.dto.UniversityResponseDto;
import com.ejournal.university.info.dto.UniversityRequestDto;
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
    public ResponseEntity<ResponseDto> createUniversity(@RequestBody UniversityRequestDto universityRequestDto){

        universityService.create(universityRequestDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto(STATUS_CODE_201, "University" + STATUS_MESSAGE_201));
    }

    @GetMapping
    public ResponseEntity<UniversityResponseDto> fetchUniversityDetails(){

        UniversityResponseDto universityResponseDto = universityService.fetchById(0L);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(universityResponseDto);
    }

    @PutMapping
    public ResponseEntity<UniversityResponseDto> updateUniversityDetails(@RequestBody UniversityRequestDto universityRequestDto){

        UniversityResponseDto updatedUniversityResponseDto = universityService.update(universityRequestDto);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(updatedUniversityResponseDto);
    }

    @DeleteMapping
    public ResponseEntity<ResponseDto> deleteUniversity(){

        universityService.deleteById(0L);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ResponseDto(STATUS_CODE_200, "University" + INSTANCE_DELETED));
    }

}
