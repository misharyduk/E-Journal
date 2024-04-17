package com.ejournal.journal.journal.dto;

import com.ejournal.journal.common.dto.PageableResponseDto;
import com.ejournal.journal.common.feign_client.group.dto.GroupResponseDto;
import com.ejournal.journal.common.feign_client.university.dto.SubjectResponseDto;
import com.ejournal.journal.common.feign_client.university.dto.TeacherResponseDto;
import com.ejournal.journal.lesson_journal.dto.LessonResponseDto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class JournalResponseDto {
    private Long id;
    private String semesterNumber;
    private List<AcademicModuleResponseDto> academicModules;
    private SubjectResponseDto subject;
    private GroupResponseDto group;
    private TeacherResponseDto lectureTeacher;
    private TeacherResponseDto practicalTeacher;
    private PageableResponseDto<LessonResponseDto> lessons;
}
