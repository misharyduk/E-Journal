package com.ejournal.analytics.feign_client.university;

import com.ejournal.analytics.feign_client.university.dto.TeacherResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient("university")
public interface UniversityFeignClient {

    @GetMapping("/api/v1/teachers/all")
    ResponseEntity<List<TeacherResponseDto>> fetchAllTeachers();

}
