package com.ejournal.group.student.controller;

import com.ejournal.group.common.dto.PageableRequestDto;
import com.ejournal.group.common.dto.PageableResponseDto;
import com.ejournal.group.common.dto.ResponseDto;
import com.ejournal.group.student.dto.StudentRequestDto;
import com.ejournal.group.student.dto.StudentResponseDto;
import com.ejournal.group.student.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.ejournal.group.common.util.ServiceConstants.INSTANCE_DELETED;

@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping
    public ResponseEntity<StudentResponseDto> createStudent(@RequestBody StudentRequestDto studentRequestDto){

        StudentResponseDto responseDto = studentService.create(studentRequestDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(responseDto);
    }

    @GetMapping
    public ResponseEntity<PageableResponseDto<StudentResponseDto>> fetchPageOfStudents(PageableRequestDto pageableRequestDto){

        PageableResponseDto<StudentResponseDto> pageOfStudents = studentService.fetchPage(pageableRequestDto);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(pageOfStudents);
    }

    @GetMapping("/group/{groupId}")
    public ResponseEntity<List<StudentResponseDto>> fetchAllStudentsOfGroup(@PathVariable("groupId") Long groupId){

        List<StudentResponseDto> listOfStudents = studentService.fetchByGroupId(groupId);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(listOfStudents);
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<StudentResponseDto> fetchStudent(@PathVariable("studentId") Long studentId){

        StudentResponseDto responseDto = studentService.fetchById(studentId);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(responseDto);
    }

    @PutMapping("/{studentId}")
    public ResponseEntity<StudentResponseDto> updateStudent(@PathVariable("studentId") Long studentId,
                                                            @RequestBody StudentRequestDto studentRequestDto){

        StudentResponseDto updatedResponseDto = studentService.update(studentId, studentRequestDto);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(updatedResponseDto);
    }

    @DeleteMapping("/{studentId}")
    public ResponseEntity<ResponseDto> deleteStudent(@PathVariable("studentId") Long studentId){

        studentService.deleteById(studentId);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ResponseDto(HttpStatus.OK.toString(), "Student" + INSTANCE_DELETED));
    }

}
