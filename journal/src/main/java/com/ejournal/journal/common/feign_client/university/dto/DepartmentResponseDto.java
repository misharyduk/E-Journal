package com.ejournal.journal.common.feign_client.university.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class DepartmentResponseDto {

    private Long departmentId;
    private String departmentName;
    private String departmentDescription;
    private String officeNumber;
    private String mobilePhone;
    private String email;

}
