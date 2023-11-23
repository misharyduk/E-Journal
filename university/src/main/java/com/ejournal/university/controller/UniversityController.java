package com.ejournal.university.controller;

import com.ejournal.university.dto.ResponseDto;
import com.ejournal.university.dto.UniversityRequestDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/university/")
public class UniversityController {

    @PostMapping
    public ResponseEntity<ResponseDto> createUniversity(@RequestBody UniversityRequestDto universityRequestDto){

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto(HttpStatus.CREATED.toString(), "University has been successfully created"));
    }

}
