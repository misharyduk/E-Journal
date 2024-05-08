package com.ejournal.journal.exercise_journal.service;

import com.ejournal.journal.common.dto.PageableRequestDto;
import com.ejournal.journal.common.dto.PageableResponseDto;
import com.ejournal.journal.common.service.CommonCrudService;
import com.ejournal.journal.exercise_journal.dto.PracticeJournalResponseDto;
import com.ejournal.journal.exercise_journal.dto.WorkStudentMarkRequestDto;
import com.ejournal.journal.journal.dto.JournalRequestDto;
import com.ejournal.journal.journal.dto.JournalResponseDto;

import java.util.List;

public interface PracticeJournalService {

    PracticeJournalResponseDto fetchById(Long id);

    PracticeJournalResponseDto markStudentGrade(Long practiceJournalId, WorkStudentMarkRequestDto markRequestDto);

    PracticeJournalResponseDto updateStudentGrade(Long practiceJournalId, Long gradeId, WorkStudentMarkRequestDto markRequestDto);

}
