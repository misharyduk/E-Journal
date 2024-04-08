package com.ejournal.university.common.dto;

import lombok.Setter;

@Setter
public class PageableRequestDto {
    private Integer page;
    private Integer size;
    private String field;
    private String dir;

    public Integer getPage() {
        return page != null && page > 0 ? page : 1;
    }

    public Integer getSize() {
        return size != null && size > 0 ? size : 10;
    }

    public String getField() {
        return field != null && !field.isEmpty() && !field.isBlank() ? field : "id";
    }

    public String getDir() {
        return dir != null && dir.equalsIgnoreCase("desc") ? dir : "asc";
    }
}
