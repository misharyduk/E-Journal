package com.ejournal.analytics.dto;

import lombok.Builder;
import lombok.Data;

import java.util.HashMap;

@Data @Builder
public class SemesterGradesAnalyticsResponse {
    private Integer totalNumberOfStudents;
    private HashMap<String, Integer> gradeAnalytics;
    private HashMap<String, Integer> percentageAnalytics;
}
