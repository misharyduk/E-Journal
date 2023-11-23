package com.ejournal.university.info.controller;

import com.ejournal.university.common.dto.ResponseDto;
import com.ejournal.university.info.dto.UniversityRequestDto;
import com.ejournal.university.info.dto.UniversityResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/university/")
public class UniversityController {

    @PostMapping
    public ResponseEntity<ResponseDto> createUniversity(@RequestBody UniversityRequestDto universityRequestDto){

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto(HttpStatus.CREATED.toString(), "University has been successfully created"));
    }

    @GetMapping
    public ResponseEntity<UniversityResponseDto> fetchUniversityDetails(){

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new UniversityResponseDto());
    }

    @PutMapping
    public ResponseEntity<UniversityResponseDto> updateUniversityDetails(@RequestBody UniversityRequestDto universityRequestDto){

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new UniversityResponseDto());
    }

    @DeleteMapping
    public ResponseEntity<ResponseDto> deleteUniversity(){

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ResponseDto(HttpStatus.OK.toString(), "University has been successfully deleted"));
    }

}
