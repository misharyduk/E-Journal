package com.ejournal.journal.control_journal.service;

import com.ejournal.journal.control_journal.dto.ControlJournalResponseDto;
import com.ejournal.journal.control_journal.dto.ControlMarkRequestDto;

public interface ControlJournalService {
    ControlJournalResponseDto fetchById(Long controlJournalId);

    ControlJournalResponseDto updateControlJournalGrade(Long controlJournalId, Long moduleId, ControlMarkRequestDto markRequestDto);
}
