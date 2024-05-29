package com.ejournal.journal.journal.dto;

import com.ejournal.journal.common.feign_client.group.dto.GroupResponseDto;
import com.ejournal.journal.common.feign_client.university.dto.SubjectResponseDto;
import com.ejournal.journal.common.feign_client.university.dto.TeacherResponseDto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class JournalResponseDto {
    private Long id;
    private String semesterNumber;
    private Integer firstAcademicYear;
    private Integer secondAcademicYear;
    private List<AcademicModuleResponseDto> academicModules;
    private SubjectResponseDto subject;
    private GroupResponseDto group;
    private TeacherResponseDto lectureTeacher;
    private TeacherResponseDto practicalTeacher;
    private TeacherResponseDto secondPracticalTeacher;

    private Long lectureLessonsJournalId;
    private Long practiceLessonsJournalId;
    private Long exerciseJournalId;
    private Long controlJournalId;
}
