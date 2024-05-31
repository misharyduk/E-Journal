package com.ejournal.analytics.feign_client.university.dto;

import lombok.Builder;
import lombok.Data;

@Data @Builder
public class TeacherResponseDto {

    private Long teacherId;
    private String firstName;
    private String lastName;
    private String middleName;
    private String mobilePhone;
    private String email;

}
