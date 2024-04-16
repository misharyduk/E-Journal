package com.ejournal.journal.lesson_journal.controller;

import com.ejournal.journal.common.dto.ResponseDto;
import com.ejournal.journal.lesson_journal.dto.LessonRequestDto;
import com.ejournal.journal.lesson_journal.dto.LessonResponseDto;
import com.ejournal.journal.lesson_journal.service.LessonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.ejournal.journal.common.util.ServiceConstants.INSTANCE_DELETED;

@RestController
@RequestMapping("/api/v1/lessons")
@RequiredArgsConstructor
public class LessonController {

    private final LessonService lessonService;

    @PostMapping
    public ResponseEntity<LessonResponseDto> createLesson(@RequestBody LessonRequestDto lessonRequestDto){

        LessonResponseDto lessonResponseDto = lessonService.create(lessonRequestDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(lessonResponseDto);
    }

    @GetMapping("/{lessonId}")
    public ResponseEntity<LessonResponseDto> fetchLesson(@PathVariable("lessonId") Long lessonId){

        LessonResponseDto responseDto = lessonService.fetchById(lessonId);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(responseDto);
    }

    @PutMapping("/{lessonId}")
    public ResponseEntity<LessonResponseDto> updateLesson(@PathVariable("lessonId") Long lessonId,
                                                        @RequestBody LessonRequestDto lessonRequestDto){

        LessonResponseDto updatedResponseDto = lessonService.update(lessonId, lessonRequestDto);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(updatedResponseDto);
    }

    @DeleteMapping("/{lessonId}")
    public ResponseEntity<ResponseDto> deleteLesson(@PathVariable("lessonId") Long lessonId){

        lessonService.deleteById(lessonId);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ResponseDto(HttpStatus.OK.toString(), "Lesson" + INSTANCE_DELETED));
    }
}
