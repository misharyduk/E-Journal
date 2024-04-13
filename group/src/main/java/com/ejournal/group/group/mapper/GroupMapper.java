package com.ejournal.group.group.mapper;

import com.ejournal.group.group.dto.GroupRequestDto;
import com.ejournal.group.group.dto.GroupResponseDto;
import com.ejournal.group.group.entity.Group;
import com.ejournal.group.student.mapper.StudentMapper;

import java.util.List;

public class GroupMapper {

    public static Group mapToEntity(GroupRequestDto requestDto, Group group){
        group.setGroupNumber(requestDto.getGroupNumber());
        return group;
    }

    public static GroupResponseDto basicMapToDto(Group group){
        return GroupResponseDto.builder()
                .setGroupId(group.getId())
                .setGroupNumber(group.getGroupNumber())
                .build();
    }

    public static GroupResponseDto mapToDto(Group group){
        GroupResponseDto responseDto = basicMapToDto(group);
        if(group.getStudents() != null && !group.getStudents().isEmpty()){
            responseDto.setStudents(
                    group.getStudents().stream()
                            .map(StudentMapper::basicMapToDto)
                            .toList()
            );
        }
        return responseDto;
    }
}
