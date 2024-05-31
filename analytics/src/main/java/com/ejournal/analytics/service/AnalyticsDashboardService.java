package com.ejournal.analytics.service;

import com.ejournal.analytics.dto.AllStudentsSemesterGradesDiagram;
import com.ejournal.analytics.dto.AllStudentsAttendancesGraphValue;
import com.ejournal.analytics.dto.GeneralDashboardAnalytics;
import com.ejournal.analytics.dto.StudentsTendentionGraphByGroup;
import com.ejournal.analytics.feign_client.group.GroupFeignClient;
import com.ejournal.analytics.feign_client.group.dto.GroupResponseDto;
import com.ejournal.analytics.feign_client.group.dto.StudentResponseDto;
import com.ejournal.analytics.feign_client.journal.JournalFeignClient;
import com.ejournal.analytics.feign_client.journal.dto.LessonAttendanceResponseDto;
import com.ejournal.analytics.feign_client.journal.dto.WorkStudentMarkResponseDto;
import com.ejournal.analytics.feign_client.university.UniversityFeignClient;
import com.ejournal.analytics.feign_client.university.dto.TeacherResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class AnalyticsDashboardService {

    private final GroupFeignClient groupFeignClient;
    private final JournalFeignClient journalFeignClient;
    private final UniversityFeignClient universityFeignClient;

    public GeneralDashboardAnalytics calculateGeneralDashboardAnalytics() {
        // all students
        List<StudentResponseDto> students = groupFeignClient.fetchAllOfStudents().getBody();
        int allStudentsNumber = 0;
        if(students != null){
            allStudentsNumber = students.size();
        }

        // number of students with A grade
        List<WorkStudentMarkResponseDto> allStudentsGrades = journalFeignClient.getAllStudentsGrades().getBody();
        int numberOfStudentsWithAGrade = 0;
        List<WorkStudentMarkResponseDto> allStudentsWithAGrade = new ArrayList<>();
        List<WorkStudentMarkResponseDto> allStudentsWithNoAGrade = new ArrayList<>();
        for (WorkStudentMarkResponseDto grade : allStudentsGrades){
            if(grade.getMark() < 90 && allStudentsWithAGrade.stream().anyMatch(g -> g.getStudentId().equals(grade.getStudentId()))){
                allStudentsWithAGrade.remove(grade);
                allStudentsWithNoAGrade.add(grade);
            } else if(grade.getMark() >= 90 && allStudentsWithNoAGrade.stream().noneMatch(g -> g.getStudentId().equals(grade.getStudentId())) && allStudentsWithAGrade.stream().noneMatch(g -> g.getStudentId().equals(grade.getStudentId()))){
                allStudentsWithAGrade.add(grade);
            }
        }
        numberOfStudentsWithAGrade = allStudentsWithAGrade.size();

        // number of teacher in department
        List<TeacherResponseDto> allTeachers = universityFeignClient.fetchAllTeachers().getBody();
        int allTeachersNumber = 0;
        if(allTeachers != null){
            allTeachersNumber = allTeachers.size();
        }

        return GeneralDashboardAnalytics.builder()
                .numberOfStudentsInDepartment(allStudentsNumber)
                .numberOfStudentsWithAGrade(numberOfStudentsWithAGrade)
                .numberOfTeacherInDepartment(allTeachersNumber)
                .numberOfActiveUsers(1)
                .build();
    }


    public List<AllStudentsAttendancesGraphValue> calculateAllStudentsAttendancesGraph() {
        List<GroupResponseDto> allGroups = groupFeignClient.fetchAllGroups().getBody();
        List<StudentResponseDto> allStudents = groupFeignClient.fetchAllOfStudents().getBody();

        List<LessonAttendanceResponseDto> allAttendances = journalFeignClient.getAllLessonAttendances().getBody();

        HashMap<StudentResponseDto, Integer> allStudentsAttendances = new HashMap<>();

        for (LessonAttendanceResponseDto attendance : allAttendances){
            Optional<StudentResponseDto> studentResponseDtoOpt = allStudents.stream().filter(s -> s.getId().equals(attendance.getStudentId())).findAny();
            if(studentResponseDtoOpt.isPresent()){
                StudentResponseDto studentResponseDto = studentResponseDtoOpt.get();
                if(allStudentsAttendances.containsKey(studentResponseDto)){
                    allStudentsAttendances.merge(studentResponseDto, 1, Integer::sum);
                } else {
                    allStudentsAttendances.put(studentResponseDto, 0);
                }
            }
        }

        boolean isPresent = false;
        for(StudentResponseDto student : allStudents){
            for(LessonAttendanceResponseDto attendance : allAttendances){
                if(student.getId().equals(attendance.getStudentId())){
                    isPresent = true;
                    break;
                }
            }
            if(!isPresent){
                allStudentsAttendances.put(student, 0);
            }
        }

        List<AllStudentsAttendancesGraphValue> allStudentsAttendancesGraphValues = new ArrayList<>();
        for (Map.Entry<StudentResponseDto, Integer> nextEntity : allStudentsAttendances.entrySet()) {
            Integer groupNumber = nextEntity.getKey().getGroupResponseDto().getGroupNumber();
            if (allStudentsAttendancesGraphValues.contains(groupNumber)) {
                AllStudentsAttendancesGraphValue studentsAttendancesGraphValue = allStudentsAttendancesGraphValues.get(groupNumber);
                studentsAttendancesGraphValue.setNumberOfAttendances(studentsAttendancesGraphValue.getNumberOfAttendances() + 1);
            } else {
                AllStudentsAttendancesGraphValue studentsAttendancesGraphValue = new AllStudentsAttendancesGraphValue();
                studentsAttendancesGraphValue.setGroupNumber(groupNumber);
                studentsAttendancesGraphValue.setNumberOfAttendances(0);
                allStudentsAttendancesGraphValues.add(studentsAttendancesGraphValue);
            }
        }

        return allStudentsAttendancesGraphValues;

    }

    public AllStudentsSemesterGradesDiagram calculateAllStudentsSemesterGradesDiagram() {
        return null;
    }

    public StudentsTendentionGraphByGroup calculateStudentsTendentionGraphByGroup(Long groupId) {
        return null;
    }
}
