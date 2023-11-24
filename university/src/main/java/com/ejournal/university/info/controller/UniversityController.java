package com.ejournal.university.info.controller;

import com.ejournal.university.common.dto.ResponseDto;
import com.ejournal.university.info.dto.UniversityDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/university")
public class UniversityController {

    @PostMapping
    public ResponseEntity<ResponseDto> createUniversity(@RequestBody UniversityDto universityRequestDto){

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto(HttpStatus.CREATED.toString(), "University has been successfully created"));
    }

    @GetMapping
    public ResponseEntity<UniversityDto> fetchUniversityDetails(){

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new UniversityDto());
    }

    @PutMapping
    public ResponseEntity<UniversityDto> updateUniversityDetails(@RequestBody UniversityDto universityRequestDto){

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new UniversityDto());
    }

    @DeleteMapping
    public ResponseEntity<ResponseDto> deleteUniversity(){

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ResponseDto(HttpStatus.OK.toString(), "University has been successfully deleted"));
    }

}
