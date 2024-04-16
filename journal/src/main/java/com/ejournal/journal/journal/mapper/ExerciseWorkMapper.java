package com.ejournal.journal.journal.mapper;

import com.ejournal.journal.journal.dto.ExerciseWorkRequestDto;
import com.ejournal.journal.journal.dto.ExerciseWorkResponseDto;
import com.ejournal.journal.journal.entity.academic_entities.ExerciseWork;
import com.ejournal.journal.journal.entity.academic_entities.ExerciseWorkType;

public class ExerciseWorkMapper {

    public static ExerciseWork mapToEntity(ExerciseWorkRequestDto requestDto, ExerciseWork exerciseWork){
        exerciseWork.setWorkNumber(requestDto.getWorkNumber());
        exerciseWork.setExerciseWorkType(ExerciseWorkType.valueOf(requestDto.getLessonType().toUpperCase()));
        return exerciseWork;
    }

    public static ExerciseWorkResponseDto mapToDto(ExerciseWork exerciseWork){
        ExerciseWorkResponseDto responseDto = new ExerciseWorkResponseDto();
        responseDto.setId(exerciseWork.getId());
        responseDto.setWorkNumber(exerciseWork.getWorkNumber());
        responseDto.setLessonType(exerciseWork.getExerciseWorkType().toString().toLowerCase());
        return responseDto;
    }
}
