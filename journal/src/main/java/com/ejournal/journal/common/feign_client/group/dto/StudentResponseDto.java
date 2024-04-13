package com.ejournal.journal.common.feign_client.group.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class StudentResponseDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String middleName;

}
