package com.ejournal.journal.common.feign_client.group;

import com.ejournal.journal.common.feign_client.group.dto.GroupResponseDto;
import com.ejournal.journal.common.feign_client.group.dto.StudentResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("group")
public interface GroupFeignClient {

    @GetMapping("/api/v1/groups/{groupId}")
    ResponseEntity<GroupResponseDto> fetchGroup(@PathVariable("groupId") Long groupId);

    @GetMapping("/api/v1/students/{studentId}")
    ResponseEntity<StudentResponseDto> fetchStudent(@PathVariable("studentId") Long studentId);
}
