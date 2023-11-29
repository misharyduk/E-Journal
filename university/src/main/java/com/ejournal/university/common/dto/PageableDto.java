package com.ejournal.university.common.dto;

public class PageableDto {
    private Integer page;
    private Integer size;
    private String field;

    public Integer getPage() {
        return page > 0 ? page : 1;
    }

    public Integer getSize() {
        return size > 0 ? size : 10;
    }

    public String getField() {
        return field != null && !field.isEmpty() && !field.isBlank() ? field : "id";
    }
}
