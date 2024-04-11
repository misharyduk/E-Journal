package com.ejournal.group.group.controller;

import com.ejournal.group.common.dto.PageableRequestDto;
import com.ejournal.group.common.dto.PageableResponseDto;
import com.ejournal.group.common.dto.ResponseDto;
import com.ejournal.group.group.dto.GroupRequestDto;
import com.ejournal.group.group.dto.GroupResponseDto;
import com.ejournal.group.group.service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.ejournal.group.common.util.ServiceConstants.INSTANCE_DELETED;

@RestController
@RequestMapping("/api/v1/groups")
@RequiredArgsConstructor
public class GroupController {

    private final GroupService groupService;

    @PostMapping
    public ResponseEntity<GroupResponseDto> createGroup(@RequestBody GroupRequestDto groupRequestDto){

        GroupResponseDto responseDto = groupService.create(groupRequestDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(responseDto);
    }

    @GetMapping
    public ResponseEntity<PageableResponseDto<GroupResponseDto>> fetchPageOfGroups(PageableRequestDto pageableRequestDto){

        PageableResponseDto<GroupResponseDto> pageOfGroups = groupService.fetchPage(pageableRequestDto);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(pageOfGroups);
    }

    @GetMapping("/{groupId}")
    public ResponseEntity<GroupResponseDto> fetchGroup(@PathVariable("groupId") Long groupId){

        GroupResponseDto responseDto = groupService.fetchById(groupId);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(responseDto);
    }

    @PutMapping("/{groupId}")
    public ResponseEntity<GroupResponseDto> updateGroup(@PathVariable("groupId") Long groupId,
                                                            @RequestBody GroupRequestDto groupRequestDto){

        GroupResponseDto updatedResponseDto = groupService.update(groupId, groupRequestDto);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(updatedResponseDto);
    }

    @DeleteMapping("/{groupId}")
    public ResponseEntity<ResponseDto> deleteGroup(@PathVariable("groupId") Long groupId){

        groupService.deleteById(groupId);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ResponseDto(HttpStatus.OK.toString(), "Group" + INSTANCE_DELETED));
    }

}
