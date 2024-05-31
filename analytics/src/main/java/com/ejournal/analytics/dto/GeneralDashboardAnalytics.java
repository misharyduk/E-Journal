package com.ejournal.analytics.dto;

import lombok.Builder;
import lombok.Data;

@Data @Builder
public class GeneralDashboardAnalytics {
    private Integer numberOfStudentsInDepartment;
    private Integer numberOfStudentsWithAGrade;
    private Integer numberOfTeacherInDepartment;
    private Integer numberOfActiveUsers;
}
