package com.ejournal.university.controller;

import com.ejournal.university.dto.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/teachers")
public class TeacherController {

    @PostMapping
    public ResponseEntity<ResponseDto> createTeacher(@RequestBody TeacherRequestDto teacherRequestDto){

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto(HttpStatus.CREATED.toString(), "Teacher has been successfully created"));
    }

    @GetMapping
    public ResponseEntity<List<TeacherResponseDto>> fetchAllTeachers(){

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(List.of());
    }

    @GetMapping("/{teacherId}")
    public ResponseEntity<TeacherResponseDto> fetchTeacher(@PathVariable("teacherId") Integer teacherId){

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new TeacherResponseDto());
    }

    @PutMapping
    public ResponseEntity<TeacherResponseDto> updateTeacher(@RequestBody TeacherRequestDto teacherRequestDto){

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new TeacherResponseDto());
    }

    @DeleteMapping("/{teacherId}")
    public ResponseEntity<ResponseDto> deleteTeacher(@PathVariable("teacherId") Integer teacherId){

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ResponseDto(HttpStatus.OK.toString(), "Teacher has been successfully created"));
    }

}
