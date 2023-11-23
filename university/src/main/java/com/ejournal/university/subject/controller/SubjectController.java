package com.ejournal.university.subject.controller;

import com.ejournal.university.common.dto.ResponseDto;
import com.ejournal.university.subject.dto.SubjectRequestDto;
import com.ejournal.university.subject.dto.SubjectResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/subjects")
public class SubjectController {

    @PostMapping
    public ResponseEntity<ResponseDto> createSubject(@RequestBody SubjectRequestDto subjectRequestDto){

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto(HttpStatus.CREATED.toString(), "Subject has been successfully created"));
    }

    @GetMapping
    public ResponseEntity<List<SubjectResponseDto>> fetchAllSubjects(){

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(List.of());
    }

    @GetMapping("/{subjectId}")
    public ResponseEntity<SubjectResponseDto> fetchSubject(@PathVariable("subjectId") Integer subjectId){

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new SubjectResponseDto());
    }

    @PutMapping
    public ResponseEntity<SubjectResponseDto> updateSubject(@RequestBody SubjectRequestDto subjectRequestDto){

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new SubjectResponseDto());
    }

    @DeleteMapping("/{subjectId}")
    public ResponseEntity<ResponseDto> deleteSubject(@PathVariable("subjectId") Integer subjectId){

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ResponseDto(HttpStatus.OK.toString(), "Subject has been successfully created"));
    }

}
