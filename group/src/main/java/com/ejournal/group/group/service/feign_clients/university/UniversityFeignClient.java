package com.ejournal.group.group.service.feign_clients.university;

import com.ejournal.group.group.service.feign_clients.university.dto.DepartmentResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("university")
public interface UniversityFeignClient {

    @GetMapping("/api/v1/departments/{departmentId}")
    ResponseEntity<DepartmentResponseDto> fetchDepartment(@PathVariable("departmentId") Long departmentId);

}
