package com.ejournal.analytics.feign_client.group.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data @Builder
public class StudentResponseDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String middleName;
    private String mobilePhone;
    private String email;
    private GroupResponseDto groupResponseDto;

}
