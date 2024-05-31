package com.ejournal.journal.lesson_journal.service.impl;

import com.ejournal.journal.lesson_journal.dto.LessonAttendanceResponseDto;
import com.ejournal.journal.lesson_journal.repository.LessonAttendanceRepository;
import com.ejournal.journal.lesson_journal.service.AttendanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AttendanceServiceImpl implements AttendanceService {

    private final LessonAttendanceRepository attendanceRepository;

    @Override
    public List<LessonAttendanceResponseDto> fetchAllLessonAttendances() {
        return attendanceRepository.fetchAllAttendances().stream()
                .map(la -> new LessonAttendanceResponseDto(la.getId(), la.getStudentId(), la.getLesson().getId(), la.getAttendanceValue()))
                .toList();
    }
}
