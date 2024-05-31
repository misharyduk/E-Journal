package com.ejournal.journal.lesson_journal.controller;

import com.ejournal.journal.lesson_journal.dto.LessonAttendanceResponseDto;
import com.ejournal.journal.lesson_journal.service.AttendanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/attendance")
@RequiredArgsConstructor
public class AttendanceController {

    private final AttendanceService attendanceService;

    @GetMapping
    public ResponseEntity<List<LessonAttendanceResponseDto>> getAllLessonAttendances(){
        List<LessonAttendanceResponseDto> attendances = attendanceService.fetchAllLessonAttendances();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(attendances);
    }

}
