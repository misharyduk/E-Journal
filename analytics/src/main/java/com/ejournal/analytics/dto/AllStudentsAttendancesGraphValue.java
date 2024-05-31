package com.ejournal.analytics.dto;

import lombok.Builder;
import lombok.Data;

@Data
public class AllStudentsAttendancesGraphValue {
    private Integer groupNumber;
    private Integer numberOfAttendances;
}
