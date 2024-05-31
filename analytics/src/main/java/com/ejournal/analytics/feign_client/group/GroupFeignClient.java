package com.ejournal.analytics.feign_client.group;

import com.ejournal.analytics.feign_client.group.dto.GroupResponseDto;
import com.ejournal.analytics.feign_client.group.dto.StudentResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient("group")
public interface GroupFeignClient {

    @GetMapping("/api/v1/students/all")
    ResponseEntity<List<StudentResponseDto>> fetchAllOfStudents();

    @GetMapping("/api/v1/groups/all")
    ResponseEntity<List<GroupResponseDto>> fetchAllGroups();
}
