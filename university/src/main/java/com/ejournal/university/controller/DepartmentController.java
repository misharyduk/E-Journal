package com.ejournal.university.controller;

import com.ejournal.university.dto.DepartmentRequestDto;
import com.ejournal.university.dto.DepartmentResponseDto;
import com.ejournal.university.dto.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/departments")
public class DepartmentController {

    @PostMapping
    public ResponseEntity<ResponseDto> createDepartment(@RequestBody DepartmentRequestDto departmentRequestDto){

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto(HttpStatus.CREATED.toString(), "Department has been successfully created"));
    }

    @GetMapping
    public ResponseEntity<List<DepartmentResponseDto>> fetchAllDepartments(){

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(List.of());
    }

    @GetMapping("/{departmentId}")
    public ResponseEntity<DepartmentResponseDto> fetchDepartment(@PathVariable("departmentId") Integer departmentId){

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new DepartmentResponseDto());
    }

    @PutMapping
    public ResponseEntity<DepartmentResponseDto> updateDepartment(@RequestBody DepartmentRequestDto departmentRequestDto){

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new DepartmentResponseDto());
    }

    @DeleteMapping("/{departmentId}")
    public ResponseEntity<ResponseDto> deleteDepartment(@PathVariable("departmentId") Integer departmentId){

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ResponseDto(HttpStatus.OK.toString(), "Department has been successfully deleted"));
    }

}
