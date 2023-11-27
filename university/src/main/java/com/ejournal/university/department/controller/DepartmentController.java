package com.ejournal.university.department.controller;

import com.ejournal.university.department.dto.DepartmentRequestDto;
import com.ejournal.university.department.dto.DepartmentResponseDto;
import com.ejournal.university.common.dto.ResponseDto;
import com.ejournal.university.department.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.ejournal.university.common.util.ServiceConstants.*;

@RestController
@RequestMapping("/api/v1/departments")
@RequiredArgsConstructor
public class DepartmentController {

    private final DepartmentService departmentService;

    @PostMapping
    public ResponseEntity<ResponseDto> createDepartment(@RequestBody DepartmentRequestDto departmentRequestDto){

        departmentService.create(departmentRequestDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto(STATUS_CODE_201, "Department" + STATUS_MESSAGE_201));
    }

    @GetMapping
    public ResponseEntity<List<DepartmentResponseDto>> fetchAllDepartments(){

        List<DepartmentResponseDto> departmentResponseDtos = departmentService.fetchAll();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(departmentResponseDtos);
    }

    @GetMapping("/{departmentId}")
    public ResponseEntity<DepartmentResponseDto> fetchDepartment(@PathVariable("departmentId") Long departmentId){

        DepartmentResponseDto departmentResponseDto = departmentService.fetchById(departmentId);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(departmentResponseDto);
    }

    @PutMapping("/{departmentId}")
    public ResponseEntity<DepartmentResponseDto> updateDepartment(@PathVariable("departmentId") Long departmentId,
                                                                  @RequestBody DepartmentRequestDto departmentRequestDto){

        DepartmentResponseDto updatedDepartmentResponseDto = departmentService.update(departmentId, departmentRequestDto);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(updatedDepartmentResponseDto);
    }

    @DeleteMapping("/{departmentId}")
    public ResponseEntity<ResponseDto> deleteDepartment(@PathVariable("departmentId") Long departmentId){

        departmentService.deleteById(departmentId);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ResponseDto(STATUS_CODE_200, "Department" + INSTANCE_DELETED));
    }

}
