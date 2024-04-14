package com.ejournal.journal.journal.dto;

import com.ejournal.journal.common.dto.PageableResponseDto;
import com.ejournal.journal.common.feign_client.group.dto.GroupResponseDto;
import com.ejournal.journal.common.feign_client.university.dto.SubjectResponseDto;
import com.ejournal.journal.common.feign_client.university.dto.TeacherResponseDto;
import com.ejournal.journal.lesson.dto.LessonResponseDto;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class JournalResponseDto {
    private Long id;
    private SubjectResponseDto subject;
    private GroupResponseDto group;
    private TeacherResponseDto teacher;
    private PageableResponseDto<LessonResponseDto> lessons;
}
