package com.ejournal.journal.lesson.mapper;

import com.ejournal.journal.lesson.dto.LessonRequestDto;
import com.ejournal.journal.lesson.dto.LessonResponseDto;
import com.ejournal.journal.lesson.entity.Lesson;

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
        lessonResponseDto.setJournalId(lesson.getJournal().getId());
        return lessonResponseDto;
    }

}
