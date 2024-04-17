package com.ejournal.journal.exercise_journal.service.impl;

import com.ejournal.journal.common.dto.PageableRequestDto;
import com.ejournal.journal.exercise_journal.dto.PracticeJournalResponseDto;
import com.ejournal.journal.exercise_journal.dto.WorkStudentMarkRequestDto;
import com.ejournal.journal.exercise_journal.repository.PracticeJournalRepository;
import com.ejournal.journal.exercise_journal.service.PracticeJournalService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PracticeJournalServiceImpl extends PracticeJournalService {

    private final PracticeJournalRepository practiceJournalRepository;


    @Override
    public PracticeJournalResponseDto fetchById(Long id, PageableRequestDto worksPageableRequestDto) {
        return null;
    }

    @Override
    public PracticeJournalResponseDto markStudentGrade(Long practiceJournalId, WorkStudentMarkRequestDto markRequestDto, PageableRequestDto worksPageableRequestDto) {
        return null;
    }

    @Override
    public PracticeJournalResponseDto updateStudentGrade(Long practiceJournalId, Long gradeId, PageableRequestDto worksPageableRequestDto) {
        return null;
    }

    @Override
    public PracticeJournalResponseDto deleteStudentGrade(Long practiceJournalId, Long gradeId, PageableRequestDto worksPageableRequestDto) {
        return null;
    }
}
