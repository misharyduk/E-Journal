package com.ejournal.journal.exercise_journal.mapper;

import com.ejournal.journal.exercise_journal.dto.WorkStudentMarkRequestDto;
import com.ejournal.journal.exercise_journal.dto.WorkStudentMarkResponseDto;
import com.ejournal.journal.exercise_journal.entity.WorkStudent;

public class WorkStudentMapper {
    public static WorkStudentMarkResponseDto mapMarkResponse(WorkStudent workStudent){
        return WorkStudentMarkResponseDto.builder()
                .id(workStudent.getId())
                .studentId(workStudent.getStudentId())
                .executionDate(workStudent.getExecutionDate())
                .defendDate(workStudent.getDefendDate())
                .mark(workStudent.getMark())
                .build();
    }

    public static WorkStudent mapMarkRequest(WorkStudentMarkRequestDto workStudentMarkRequestDto){
        WorkStudent workStudent = new WorkStudent();
        workStudent.setStudentId(workStudent.getStudentId());
        workStudent.setExecutionDate(workStudent.getExecutionDate());
        workStudent.setDefendDate(workStudent.getDefendDate());
        workStudent.setMark(workStudent.getMark());
        return workStudent;
    }
}
