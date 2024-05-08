package com.ejournal.journal.lesson_journal.mapper;

import com.ejournal.journal.lesson_journal.dto.LessonRequestDto;
import com.ejournal.journal.lesson_journal.dto.LessonResponseDto;
import com.ejournal.journal.lesson_journal.entity.Lesson;

public class LessonMapper {

    public static Lesson mapToEntity(LessonRequestDto lessonRequestDto, Lesson lesson){
        lesson.setType(lessonRequestDto.getType());
        lesson.setDate(lessonRequestDto.getDate());
        lesson.setOrder(lessonRequestDto.getOrder());
        lesson.setAuditory(lessonRequestDto.getAuditory());
        return lesson;
    }

    public static LessonResponseDto mapToDto(Lesson lesson, LessonResponseDto lessonResponseDto){
        lessonResponseDto.setId(lesson.getId());
        lessonResponseDto.setType(lesson.getType());
        lessonResponseDto.setDate(lesson.getDate());
        lessonResponseDto.setOrder(lesson.getOrder());
        lessonResponseDto.setAuditory(lesson.getAuditory());
        return lessonResponseDto;
    }

}
