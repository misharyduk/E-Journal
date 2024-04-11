package com.ejournal.group.group.dto.builder;

import com.ejournal.group.common.dto.builder.Builder;
import com.ejournal.group.group.dto.GroupResponseDto;
import com.ejournal.group.student.dto.StudentResponseDto;
import com.ejournal.group.student.entity.Student;

import java.util.List;

public class GroupResponseBuilder implements Builder<GroupResponseDto> {

    private Long groupId;
    private Integer groupNumber;
    private List<StudentResponseDto> students;

    private GroupResponseBuilder(){}

    public static GroupResponseBuilder getInstance(){
        return new GroupResponseBuilder();
    }

    public GroupResponseBuilder setGroupId(Long groupId) {
        this.groupId = groupId;
        return this;
    }

    public GroupResponseBuilder setGroupNumber(Integer groupNumber) {
        this.groupNumber = groupNumber;
        return this;
    }

    public GroupResponseBuilder setStudents(List<StudentResponseDto> students) {
        this.students = students;
        return this;
    }

    @Override
    public GroupResponseDto build() {
        return new GroupResponseDto(groupId, groupNumber, students);
    }
}
