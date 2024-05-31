package com.ejournal.analytics.controller;

import com.ejournal.analytics.dto.AllStudentsSemesterGradesDiagram;
import com.ejournal.analytics.dto.AllStudentsAttendancesGraphValue;
import com.ejournal.analytics.dto.GeneralDashboardAnalytics;
import com.ejournal.analytics.dto.StudentsTendentionGraphByGroup;
import com.ejournal.analytics.service.AnalyticsDashboardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/analytics_dashboard")
@RequiredArgsConstructor
public class AnalyticsDashboardController {

    private final AnalyticsDashboardService analyticsDashboardService;

    @GetMapping("/general_info")
    public ResponseEntity<GeneralDashboardAnalytics> getGeneralDashboardAnalytics(){
        GeneralDashboardAnalytics analyticsDto = analyticsDashboardService.calculateGeneralDashboardAnalytics();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(analyticsDto);
    }

    @GetMapping("/all_students_attendance_graph")
    public ResponseEntity<List<AllStudentsAttendancesGraphValue>> getAllStudentsAttendancesGraph(){
        List<AllStudentsAttendancesGraphValue> analyticsDto = analyticsDashboardService.calculateAllStudentsAttendancesGraph();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(analyticsDto);
    }

    @GetMapping("/all_students_semester_grades_diagram")
    public ResponseEntity<AllStudentsSemesterGradesDiagram> getAllStudentsSemesterGradesDiagram(){
        AllStudentsSemesterGradesDiagram analyticsDto = analyticsDashboardService.calculateAllStudentsSemesterGradesDiagram();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(analyticsDto);
    }

    @GetMapping("/students_tendention_graph_by_group/{groupId}")
    public ResponseEntity<StudentsTendentionGraphByGroup> getStudentsTendentionGraphByGroup(@PathVariable("groupId") Long groupId){
        StudentsTendentionGraphByGroup analyticsDto = analyticsDashboardService.calculateStudentsTendentionGraphByGroup(groupId);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(analyticsDto);
    }

}
