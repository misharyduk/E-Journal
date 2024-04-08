package com.ejournal.university.department.controller;

import com.ejournal.university.common.dto.PageableRequestDto;
import com.ejournal.university.common.dto.PageableResponseDto;
import com.ejournal.university.common.util.SortFieldValidator;
import com.ejournal.university.department.dto.DepartmentRequestDto;
import com.ejournal.university.department.dto.DepartmentResponseDto;
import com.ejournal.university.common.dto.ResponseDto;
import com.ejournal.university.department.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
    public ResponseEntity<DepartmentResponseDto> createDepartment(@RequestBody DepartmentRequestDto departmentRequestDto){

        DepartmentResponseDto responseDto = departmentService.create(departmentRequestDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(responseDto);
    }

    @GetMapping
    public ResponseEntity<PageableResponseDto<DepartmentResponseDto>> fetchPageOfDepartments(PageableRequestDto pageableRequestDto){

        PageableResponseDto<DepartmentResponseDto> pageOfDepartments = departmentService.fetchPage(pageableRequestDto);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(pageOfDepartments);
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
