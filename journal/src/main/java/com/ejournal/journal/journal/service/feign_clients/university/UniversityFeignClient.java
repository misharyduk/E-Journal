package com.ejournal.journal.journal.service.feign_clients.university;

import com.ejournal.journal.journal.service.feign_clients.university.dto.SubjectResponseDto;
import com.ejournal.journal.journal.service.feign_clients.university.dto.TeacherResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("university")
public interface UniversityFeignClient {

    @GetMapping("/api/v1/subjects/{subjectId}")
    ResponseEntity<SubjectResponseDto> fetchSubject(@PathVariable("subjectId") Long subjectId);

    @GetMapping("/api/v1/teachers/{teacherId}")
    ResponseEntity<TeacherResponseDto> fetchTeacher(@PathVariable("teacherId") Long teacherId);

}
