package com.ejournal.analytics.controller;

import com.ejournal.analytics.dto.SemesterGradesAnalyticsResponse;
import com.ejournal.analytics.service.ControlJournalAnalyticsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/control-analytics")
@RequiredArgsConstructor
public class ControlJournalAnalyticsController {

    private final ControlJournalAnalyticsService controlJournalAnalyticsService;

    @GetMapping("/controljournal/{controlJournalId}/semester/grades")
    public ResponseEntity<SemesterGradesAnalyticsResponse> getSemesterGradesAnalyticsByJournal(@PathVariable("controlJournalId") Long controlJournalId){
        SemesterGradesAnalyticsResponse analytics = controlJournalAnalyticsService.calculateSemesterGradesAnalytics(controlJournalId);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(analytics);
    }

}
