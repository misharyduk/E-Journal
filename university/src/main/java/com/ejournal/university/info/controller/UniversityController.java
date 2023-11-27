package com.ejournal.university.info.controller;

import com.ejournal.university.common.dto.ResponseDto;
import com.ejournal.university.info.dto.UniversityResponseDto;
import com.ejournal.university.info.dto.UniversityRequestDto;
import com.ejournal.university.info.service.UniversityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.ejournal.university.common.util.ServiceConstants.*;

@RestController
@RequestMapping("/api/v1/university")
@RequiredArgsConstructor
public class UniversityController {

    private final UniversityService universityService;

    @PostMapping
    public ResponseEntity<UniversityResponseDto> createUniversity(@RequestBody UniversityRequestDto universityRequestDto){

        UniversityResponseDto responseDto = universityService.create(universityRequestDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(responseDto);
    }

    @GetMapping("/{universityId}")
    public ResponseEntity<UniversityResponseDto> fetchUniversityDetails(@PathVariable("universityId") Long universityId){

        UniversityResponseDto universityResponseDto = universityService.fetchById(universityId);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(universityResponseDto);
    }

    @GetMapping
    public ResponseEntity<List<UniversityResponseDto>> fetchAllUniversities(){

        List<UniversityResponseDto> responseDTOs = universityService.fetchAll();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(responseDTOs);
    }

    @PutMapping("/{universityId}")
    public ResponseEntity<UniversityResponseDto> updateUniversityDetails(@PathVariable("universityId") Long universityId,
                                                                         @RequestBody UniversityRequestDto universityRequestDto){

        UniversityResponseDto updatedUniversityResponseDto = universityService.update(universityId, universityRequestDto);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(updatedUniversityResponseDto);
    }

    @DeleteMapping("/{universityId}")
    public ResponseEntity<ResponseDto> deleteUniversity(@PathVariable("universityId") Long universityId){

        universityService.deleteById(universityId);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ResponseDto(STATUS_CODE_200, "University" + INSTANCE_DELETED));
    }

}
