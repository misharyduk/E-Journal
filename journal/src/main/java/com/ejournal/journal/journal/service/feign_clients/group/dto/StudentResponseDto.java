package com.ejournal.journal.journal.service.feign_clients.group.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class StudentResponseDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String middleName;

}
