package com.ejournal.journal.journal.mapper;

import com.ejournal.journal.journal.dto.AcademicModuleResponseDto;
import com.ejournal.journal.journal.dto.ExerciseWorkRequestDto;
import com.ejournal.journal.journal.dto.ExerciseWorkResponseDto;
import com.ejournal.journal.journal.entity.academic_entities.AcademicModule;
import com.ejournal.journal.journal.entity.academic_entities.ExerciseWork;
import com.ejournal.journal.journal.entity.academic_entities.ExerciseWorkType;

public class ExerciseWorkMapper {

    public static ExerciseWork mapToEntity(ExerciseWorkRequestDto requestDto, ExerciseWork exerciseWork){
        exerciseWork.setWorkNumber(requestDto.getWorkNumber());
        exerciseWork.setLessonType(ExerciseWorkType.valueOf(requestDto.getLessonType().toUpperCase()));
        return exerciseWork;
    }

    public static ExerciseWorkResponseDto mapToDto(ExerciseWork exerciseWork){
        ExerciseWorkResponseDto responseDto = new ExerciseWorkResponseDto();
        responseDto.setId(exerciseWork.getId());
        responseDto.setWorkNumber(exerciseWork.getWorkNumber());
        responseDto.setLessonType(exerciseWork.getLessonType().toString().toLowerCase());
        return responseDto;
    }
}
