package com.ejournal.journal.journal.service.impl;

import com.ejournal.journal.common.dto.PageableRequestDto;
import com.ejournal.journal.common.dto.PageableResponseDto;
import com.ejournal.journal.common.exception.ResourceNotFoundException;
import com.ejournal.journal.common.util.SortFieldValidator.JournalField;
import com.ejournal.journal.control_journal.entity.ControlJournal;
import com.ejournal.journal.control_journal.repository.ControlJournalRepository;
import com.ejournal.journal.exercise_journal.entity.PracticeJournal;
import com.ejournal.journal.exercise_journal.repository.PracticeJournalRepository;
import com.ejournal.journal.exercise_journal.service.PracticeJournalService;
import com.ejournal.journal.journal.dto.JournalRequestDto;
import com.ejournal.journal.journal.dto.JournalResponseDto;
import com.ejournal.journal.journal.entity.Journal;
import com.ejournal.journal.journal.entity.academic_entities.SemesterNumber;
import com.ejournal.journal.journal.mapper.JournalMapper;
import com.ejournal.journal.journal.repository.JournalRepository;
import com.ejournal.journal.journal.service.JournalService;
import com.ejournal.journal.common.feign_client.group.GroupFeignClient;
import com.ejournal.journal.common.feign_client.group.dto.GroupResponseDto;
import com.ejournal.journal.common.feign_client.university.UniversityFeignClient;
import com.ejournal.journal.common.feign_client.university.dto.SubjectResponseDto;
import com.ejournal.journal.common.feign_client.university.dto.TeacherResponseDto;
import com.ejournal.journal.lesson_journal.dto.LessonResponseDto;
import com.ejournal.journal.lesson_journal.entity.LessonJournal;
import com.ejournal.journal.lesson_journal.repository.LessonJournalRepository;
import com.ejournal.journal.lesson_journal.service.LessonService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class JournalServiceImpl implements JournalService {

    // Feign Clients
    private final GroupFeignClient groupClient;
    private final UniversityFeignClient universityClient;

    private final JournalRepository journalRepository;
    private final PracticeJournalRepository practiceJournalRepository;
    private final LessonJournalRepository lessonJournalRepository;
    private final ControlJournalRepository controlJournalRepository;
    private final LessonService lessonService;

    @Override
    public JournalResponseDto create(JournalRequestDto requestDto) {
        SemesterNumber semesterNumber = SemesterNumber.valueOf(requestDto.getSemesterNumber().toUpperCase());
        Journal journal = JournalMapper.mapToEntity(requestDto, new Journal());

        PracticeJournal practiceJournal = new PracticeJournal();
        practiceJournalRepository.savePracticeJournal(practiceJournal);
        journal.setPracticeLessonJournalId(practiceJournal.getId());

        LessonJournal lectureLessonJournal = new LessonJournal();
        lessonJournalRepository.saveLessonJournal(lectureLessonJournal);
        journal.setLectureLessonJournalId(lectureLessonJournal.getId());

        LessonJournal practiceLessonJournal = new LessonJournal();
        lessonJournalRepository.saveLessonJournal(practiceLessonJournal);
        journal.setPracticeLessonJournalId(practiceLessonJournal.getId());

        ControlJournal controlJournal = new ControlJournal();
        controlJournalRepository.saveControlJournal(controlJournal);
        journal.setControlJournalId(controlJournal.getId());

        journalRepository.createInstance(journal);

        return fillJournalResponse(journal);
    }

    @Override
    public JournalResponseDto fetchById(Long id) {
        Journal journal = journalRepository.fetchInstanceById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Journal", "id", String.valueOf(id)));

        return fillJournalResponse(journal);
    }

    @Override
    public JournalResponseDto fetchById(Long id, PageableRequestDto pageableRequestDto) {
        Journal journal = journalRepository.fetchInstanceById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Journal", "id", String.valueOf(id)));

        if(pageableRequestDto == null){
            pageableRequestDto = new PageableRequestDto();
            pageableRequestDto.setPage(1);
            pageableRequestDto.setSize(10);
        }

        PageableResponseDto<LessonResponseDto> lessonsPage = lessonService
                .fetchPageByJournal(journal.getId(), pageableRequestDto);

        JournalResponseDto responseDto = fillJournalResponse(journal);
        responseDto.setLessons(lessonsPage);
        return responseDto;
    }

    @Override
    public PageableResponseDto<JournalResponseDto> fetchPage(PageableRequestDto pageableRequestDto) {

        String validSortFieldName = JournalField.validate(pageableRequestDto.getField()).getValidHQLField();

        Pageable pageable = PageRequest.of(pageableRequestDto.getPage() - 1, pageableRequestDto.getSize())
                .withSort(Sort.Direction.fromString(pageableRequestDto.getDir()), validSortFieldName);

        Page<Journal> journalsPage = journalRepository.fetchPage(pageable);
        return new PageableResponseDto<>(
                journalsPage.getTotalPages(),
                pageableRequestDto.getPage(),
                pageableRequestDto.getSize(),
                pageableRequestDto.getDir(),
                journalsPage.getTotalElements(),
                journalsPage.stream().map(this::fillJournalResponse).toList()
        );
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

    @Override
    public List<JournalResponseDto> fetchAllBySubject(Long subjectId) {
        return journalRepository.fetchAllInstancesBySubject(subjectId).stream()
                .map(this::fillJournalResponse)
                .sorted(Comparator.comparing(j -> j.getGroup().getGroupNumber()))
                .toList();
    }

    @Override
    public List<JournalResponseDto> fetchAllByTeacher(Long teacherId) {
        return journalRepository.fetchAllInstancesByTeacher(teacherId).stream()
                .map(this::fillJournalResponse)
                .sorted(Comparator.comparing(j -> j.getGroup().getGroupNumber()))
                .toList();
    }

    @Override
    public List<JournalResponseDto> fetchAllByGroup(Long groupId) {
        return journalRepository.fetchAllInstancesByGroup(groupId).stream()
                .map(this::fillJournalResponse)
                .sorted(Comparator.comparing(j -> j.getGroup().getGroupNumber()))
                .toList();
    }

    private JournalResponseDto fillJournalResponse(Journal journal) {
        JournalResponseDto responseDto = JournalMapper.mapToDto(journal);

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

        // Map Lecture Teacher
        ResponseEntity<TeacherResponseDto> lectureTeacher = universityClient.fetchTeacher(journal.getLectureTeacherId());
        if(lectureTeacher.getBody() == null)
            throw new ResourceNotFoundException("Teacher", "id", String.valueOf(journal.getLectureTeacherId()));

        responseDto.setLectureTeacher(lectureTeacher.getBody());

        // Map Practical Teacher
        ResponseEntity<TeacherResponseDto> practicalTeacher = universityClient.fetchTeacher(journal.getPracticalTeacherId());
        if(practicalTeacher.getBody() == null)
            throw new ResourceNotFoundException("Teacher", "id", String.valueOf(journal.getPracticalTeacherId()));

        responseDto.setPracticalTeacher(practicalTeacher.getBody());

        return responseDto;
    }
}
