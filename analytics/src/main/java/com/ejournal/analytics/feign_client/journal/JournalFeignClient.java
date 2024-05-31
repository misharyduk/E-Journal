package com.ejournal.analytics.feign_client.journal;

import com.ejournal.analytics.feign_client.journal.dto.ControlJournalResponseDto;
import com.ejournal.analytics.feign_client.journal.dto.LessonAttendanceResponseDto;
import com.ejournal.analytics.feign_client.journal.dto.WorkStudentMarkResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient("journal")
public interface JournalFeignClient {

    @GetMapping("/api/v1/controljournal/{controlJournalId}")
    ResponseEntity<ControlJournalResponseDto> fetchControlJournal(@PathVariable("controlJournalId") Long controlJournalId);

    @GetMapping("/api/v1/workjournal/allStudentsGrades")
    ResponseEntity<List<WorkStudentMarkResponseDto>> getAllStudentsGrades();

    @GetMapping("/api/v1/attendance")
    ResponseEntity<List<LessonAttendanceResponseDto>> getAllLessonAttendances();
}
