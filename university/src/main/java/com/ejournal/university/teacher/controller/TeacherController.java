package com.ejournal.university.teacher.controller;

import com.ejournal.university.common.dto.PageableRequestDto;
import com.ejournal.university.common.dto.PageableResponseDto;
import com.ejournal.university.common.dto.ResponseDto;
import com.ejournal.university.teacher.dto.TeacherRequestDto;
import com.ejournal.university.teacher.dto.TeacherResponseDto;
import com.ejournal.university.teacher.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.ejournal.university.common.util.ServiceConstants.INSTANCE_DELETED;

@RestController
@RequestMapping("/api/v1/teachers")
@RequiredArgsConstructor
public class TeacherController {

    private final TeacherService teacherService;

    @PostMapping
    public ResponseEntity<TeacherResponseDto> createTeacher(@RequestBody TeacherRequestDto teacherRequestDto){

        TeacherResponseDto responseDto = teacherService.create(teacherRequestDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(responseDto);
    }

    @GetMapping
    public ResponseEntity<PageableResponseDto<TeacherResponseDto>> fetchPageOfTeachers(PageableRequestDto pageableRequestDto){

        PageableResponseDto<TeacherResponseDto> pageOfTeachers = teacherService.fetchPage(pageableRequestDto);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(pageOfTeachers);
    }

    @GetMapping("/all")
    public ResponseEntity<List<TeacherResponseDto>> fetchAllTeachers(){

        List<TeacherResponseDto> allTeachers = teacherService.fetchAll();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(allTeachers);
    }

    @GetMapping("/{teacherId}")
    public ResponseEntity<TeacherResponseDto> fetchTeacher(@PathVariable("teacherId") Long teacherId){

        TeacherResponseDto responseDto = teacherService.fetchById(teacherId);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(responseDto);
    }

    @PutMapping("/{teacherId}")
    public ResponseEntity<TeacherResponseDto> updateTeacher(@PathVariable("teacherId") Long teacherId,
                                                            @RequestBody TeacherRequestDto teacherRequestDto){

        TeacherResponseDto updatedResponseDto = teacherService.update(teacherId, teacherRequestDto);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(updatedResponseDto);
    }

    @DeleteMapping("/{teacherId}")
    public ResponseEntity<ResponseDto> deleteTeacher(@PathVariable("teacherId") Long teacherId){

        teacherService.deleteById(teacherId);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ResponseDto(HttpStatus.OK.toString(), "Teacher" + INSTANCE_DELETED));
    }

}
