package com.ejournal.university.common.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter @Setter
public class PageableResponseDto<K> {

    private Integer totalPages;
    private Integer page;
    private Integer size;
    private String sort;
    private Long totalElements;
    private List<K> elements;

}
