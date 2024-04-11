package com.ejournal.group.group.dto;

import com.ejournal.group.student.entity.Student;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class GroupRequestDto {

    private Integer groupNumber;

}
