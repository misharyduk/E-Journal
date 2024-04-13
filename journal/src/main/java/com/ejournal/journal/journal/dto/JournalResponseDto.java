package com.ejournal.journal.journal.dto;

import com.ejournal.journal.common.feign_client.group.dto.GroupResponseDto;
import com.ejournal.journal.common.feign_client.university.dto.SubjectResponseDto;
import com.ejournal.journal.common.feign_client.university.dto.TeacherResponseDto;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class JournalResponseDto {
    private Long id;
    private SubjectResponseDto subject;
    private GroupResponseDto group;
    private TeacherResponseDto teacher;
}
