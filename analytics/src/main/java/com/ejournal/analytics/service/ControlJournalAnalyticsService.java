package com.ejournal.analytics.service;

import com.ejournal.analytics.dto.SemesterGradesAnalyticsResponse;
import com.ejournal.analytics.exception.ResourceNotFoundException;
import com.ejournal.analytics.feign_client.journal.JournalFeignClient;
import com.ejournal.analytics.feign_client.journal.dto.ControlJournalResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ControlJournalAnalyticsService {

    // Feign Clients
    private final JournalFeignClient controlJournalFeignClient;

    public SemesterGradesAnalyticsResponse calculateSemesterGradesAnalytics(Long controlJournalId) {
        // fetching control journal
        ResponseEntity<ControlJournalResponseDto> controlJournalResponseDtoResponse = controlJournalFeignClient.fetchControlJournal(controlJournalId);
        if(controlJournalResponseDtoResponse.getBody() == null)
            throw new ResourceNotFoundException("Control Journal", "id", String.valueOf(controlJournalId));

        ControlJournalResponseDto controlJournal = controlJournalResponseDtoResponse.getBody();

        // Calculate analytics
        HashMap<String, Integer> gradeAnalyticsMap = new HashMap<>(){
            {
                put("A", 0);
                put("B", 0);
                put("C", 0);
                put("D", 0);
                put("E", 0);
                put("FX", 0);
                put("F", 0);
            }
        };

        controlJournal.getSemesterStudentGrades()
                .forEach(g -> gradeAnalyticsMap.merge(convertGradeToECTSRange(g.getGrade()), 1, Integer::sum));

        HashMap<String, Integer> percentageAnalyticsMap = new HashMap<>();

        int totalNumberOfStudents = controlJournal.getSemesterStudentGrades().size(); // actually, numbers of grades and students are equal

        for (Map.Entry<String, Integer> gradeEntity : gradeAnalyticsMap.entrySet()) {
            percentageAnalyticsMap.put(gradeEntity.getKey(), ((100 * gradeEntity.getValue()) / totalNumberOfStudents));
        }

        return SemesterGradesAnalyticsResponse.builder()
                .gradeAnalytics(gradeAnalyticsMap)
                .percentageAnalytics(percentageAnalyticsMap)
                .totalNumberOfStudents(totalNumberOfStudents)
                .build();
    }

    private String convertGradeToECTSRange(Double grade){
        if(grade < 0 || grade > 100)
            return "Error";

        if(grade < 35)
            return "F";
        else if (grade < 60) {
            return "FX";
        } else if (grade < 67) {
            return "E";
        } else if (grade < 75){
            return "D";
        } else if (grade < 82) {
            return "C";
        } else if (grade < 90) {
            return "B";
        } else if (grade <= 100) {
            return "A";
        }

        return "N/N";
    }
}
