package com.ejournal.journal.common.util;

import lombok.Getter;

import java.util.Collection;
import java.util.EnumSet;
import java.util.Set;

public class SortFieldValidator {

    @Getter
    public enum JournalField{

        JOURNAL_ID(Set.of("id", "identifier"), "id"),
        GROUP_ID(Set.of("group", "group_id", "group_number", "group_name", "groupId"), "groupId"),
        TEACHER_ID(Set.of("teacher", "teacher_id", "teacher_number", "teacher_name", "teacherId"), "teacherId"),
        SUBJECT_ID(Set.of("subject", "subject_id", "subject_number", "subject_name", "subjectId"), "subjectId");

        private JournalField(Collection<String> fieldNameVariations, String validHQLField){
            this.fieldNameVariations = fieldNameVariations;
            this.validHQLField = validHQLField;
        }

        private final Collection<String> fieldNameVariations;
        private final String validHQLField;

        public static JournalField validate(String inputFieldName){
            EnumSet<JournalField> enumSet = EnumSet.allOf(JournalField.class);
            return enumSet.stream()
                    .filter(field -> field.getFieldNameVariations().contains(inputFieldName))
                    .findFirst()
                    .orElse(JOURNAL_ID);
        }
    }
}
