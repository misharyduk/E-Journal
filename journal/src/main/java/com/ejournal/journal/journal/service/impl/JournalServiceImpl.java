package com.ejournal.journal.journal.service.impl;

import com.ejournal.journal.common.exception.ResourceNotFoundException;
import com.ejournal.journal.journal.dto.JournalRequestDto;
import com.ejournal.journal.journal.dto.JournalResponseDto;
import com.ejournal.journal.journal.entity.Journal;
import com.ejournal.journal.journal.repository.JournalRepository;
import com.ejournal.journal.journal.service.JournalService;
import com.ejournal.journal.journal.service.feign_clients.group.GroupFeignClient;
import com.ejournal.journal.journal.service.feign_clients.group.dto.GroupResponseDto;
import com.ejournal.journal.journal.service.feign_clients.university.UniversityFeignClient;
import com.ejournal.journal.journal.service.feign_clients.university.dto.SubjectResponseDto;
import com.ejournal.journal.journal.service.feign_clients.university.dto.TeacherResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JournalServiceImpl implements JournalService {

    // Feign Clients
    private final GroupFeignClient groupClient;
    private final UniversityFeignClient universityClient;

    private final JournalRepository journalRepository;

    @Override
    public Long create(JournalRequestDto requestDto) {
        Journal journal = new Journal(requestDto.getSubjectId(), requestDto.getGroupId(), requestDto.getTeacherId());
        return journalRepository.createInstance(journal).getId();
    }

    @Override
    public JournalResponseDto fetchById(Long id) {
        Journal journal = journalRepository.fetchInstanceById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Journal", "id", String.valueOf(id)));

        return fillJournalResponse(journal);
    }

    @Override
    public List<JournalResponseDto> fetchAll() {
        return journalRepository.fetchAllInstances().stream()
                .map(this::fillJournalResponse)
                .toList();
    }

    @Override
    public boolean deleteById(Long id) {
        Journal journal = journalRepository.fetchInstanceById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Journal", "id", String.valueOf(id)));

        journalRepository.deleteInstance(journal);

        return true;
    }

    private JournalResponseDto fillJournalResponse(Journal journal) {
        JournalResponseDto responseDto = new JournalResponseDto();
        responseDto.setId(journal.getId());

        // Map Group
        ResponseEntity<GroupResponseDto> groupDto = groupClient.fetchGroup(journal.getGroupId());
        if(groupDto.getBody() == null)
            throw new ResourceNotFoundException("Group", "id", String.valueOf(journal.getGroupId()));

        responseDto.setGroup(groupDto.getBody());

        // Map Subject
        ResponseEntity<SubjectResponseDto> subjectDto = universityClient.fetchSubject(journal.getSubjectId());
        if(subjectDto.getBody() == null)
            throw new ResourceNotFoundException("Subject", "id", String.valueOf(journal.getSubjectId()));

        responseDto.setSubject(subjectDto.getBody());

        // Map Teacher
        ResponseEntity<TeacherResponseDto> teacherDto = universityClient.fetchTeacher(journal.getTeacherId());
        if(teacherDto.getBody() == null)
            throw new ResourceNotFoundException("Teacher", "id", String.valueOf(journal.getTeacherId()));

        responseDto.setTeacher(teacherDto.getBody());
        return responseDto;
    }
}
