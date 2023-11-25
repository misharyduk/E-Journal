package com.ejournal.university.department.dto;

import com.ejournal.university.common.dto.AddressDto;
import lombok.Getter;

@Getter
public class DepartmentRequestDto {

    private String departmentName;
    private String departmentDescription;
    private AddressDto address;
    private String officeNumber;
    private String mobilePhone;
    private String email;
    private Long headOfDepartmentId;

}
