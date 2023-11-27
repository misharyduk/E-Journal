package com.ejournal.university.subject.controller;

import com.ejournal.university.common.dto.ResponseDto;
import com.ejournal.university.subject.dto.SubjectRequestDto;
import com.ejournal.university.subject.dto.SubjectResponseDto;
import com.ejournal.university.subject.service.SubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.ejournal.university.common.util.ServiceConstants.INSTANCE_DELETED;

@RestController
@RequestMapping("/api/v1/subjects")
@RequiredArgsConstructor
public class SubjectController {

    private final SubjectService subjectService;

    @PostMapping
    public ResponseEntity<SubjectResponseDto> createSubject(@RequestBody SubjectRequestDto subjectRequestDto){

        SubjectResponseDto responseDto = subjectService.create(subjectRequestDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(responseDto);
    }

    @GetMapping
    public ResponseEntity<List<SubjectResponseDto>> fetchAllSubjects(){

        List<SubjectResponseDto> responseDTOs = subjectService.fetchAll();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(responseDTOs);
    }

    @GetMapping("/{subjectId}")
    public ResponseEntity<SubjectResponseDto> fetchSubject(@PathVariable("subjectId") Long subjectId){

        SubjectResponseDto responseDto = subjectService.fetchById(subjectId);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(responseDto);
    }

    @PutMapping("/{subjectId}")
    public ResponseEntity<SubjectResponseDto> updateSubject(@PathVariable("subjectId") Long subjectId,
                                                            @RequestBody SubjectRequestDto subjectRequestDto){

        SubjectResponseDto updatedResponseDto = subjectService.update(subjectId, subjectRequestDto);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(updatedResponseDto);
    }

    @DeleteMapping("/{subjectId}")
    public ResponseEntity<ResponseDto> deleteSubject(@PathVariable("subjectId") Long subjectId){

        subjectService.deleteById(subjectId);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ResponseDto(HttpStatus.OK.toString(), "Subject" + INSTANCE_DELETED));
    }

}
