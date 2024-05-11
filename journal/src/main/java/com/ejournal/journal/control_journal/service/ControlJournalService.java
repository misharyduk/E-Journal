package com.ejournal.journal.control_journal.service;

import com.ejournal.journal.control_journal.dto.ControlJournalResponseDto;
import com.ejournal.journal.control_journal.dto.ControlMarkRequestDto;
import com.ejournal.journal.control_journal.entity.ControlJournal;
import com.ejournal.journal.journal.entity.Journal;

public interface ControlJournalService {
    ControlJournalResponseDto fetchById(Long controlJournalId);

    Journal enrichAndSaveControlJournal(Journal journal);

    ControlJournalResponseDto updateControlJournalGrade(Long controlJournalId, Long moduleId, ControlMarkRequestDto markRequestDto);

    ControlJournalResponseDto updateSemesterGrade(Long controlJournalId, ControlMarkRequestDto markRequestDto);
}
